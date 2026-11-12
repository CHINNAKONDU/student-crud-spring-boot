package com.strike.crudspringboot1.Service;

import com.strike.crudspringboot1.Entity.Student;
import com.strike.crudspringboot1.respostroy.StudentRespo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

   private StudentRespo StudentRespo;
   public StudentService(StudentRespo StudentRespo){
       this.StudentRespo = StudentRespo;
   }

    public  Student createStudent(Student studentReq) {
        System.out.println("inside student service");
       Student StudentResponse = StudentRespo.save(studentReq);
        System.out.println("exist student service");
        return StudentResponse;
    }

    public Student getStudent(Long id) {
        Optional<Student> StudentResponse = StudentRespo.findById(id);
        if (StudentResponse.isPresent()) {
            return StudentResponse.get();
        }
        return null;

    }
    public List<Student> getAllStudent(){
       List<Student> studentList =StudentRespo.findAll();
       return studentList;
    }
    public Student updateStudent(Long id , Student studentReq){
        Optional<Student> existiningstudent = StudentRespo.findById(id );

        if (existiningstudent.isEmpty()) {
            return null;
        }
        Student studentTosave = existiningstudent.get();
        studentTosave.setSname(studentReq.getSname());
        studentTosave.setEmail(studentReq.getEmail());
        studentTosave.setAge(studentReq.getAge());
        studentTosave.setRollno(studentReq.getRollno());
        studentTosave.setSsubject(studentReq.getSsubject());

       return StudentRespo.save(studentTosave);


    }
    public Boolean deleteStudent(Long id){
       Boolean isStudent = StudentRespo.existsById(id);
       if(isStudent)
           return false;

        StudentRespo.deleteById(id);
        return  true;
       }
    }


