package com.strike.crudspringboot1.Controller;

import com.strike.crudspringboot1.Entity.Student;
import com.strike.crudspringboot1.Service.StudentService;
import com.strike.crudspringboot1.respostroy.StudentRespo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRespo studentRespo;
    private StudentService StudentService;

    public StudentController(StudentService StudentService, StudentRespo studentRespo) {
        this.StudentService = StudentService;
        this.studentRespo = studentRespo;
    }

    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("inside student controller");

        Student createStudent = StudentService.createStudent(student);
        System.out.println("exist student controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        System.out.println("inside student controller get");
        Student StudentReq = StudentService.getStudent(id);
        if (StudentReq == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(StudentReq);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        System.out.println("inside student controller get");
        List<Student> studentList = StudentService.getAllStudent();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student studentReq) {
        System.out.println("inside student controller get");
        Student StudentReq = StudentService.updateStudent(id,studentReq );
        if (StudentReq == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(StudentReq);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = StudentService.deleteStudent(id);

        if(isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }



}
