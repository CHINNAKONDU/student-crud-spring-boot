package com.strike.crudspringboot1.respostroy;

import com.strike.crudspringboot1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRespo extends JpaRepository<Student, Long> {




}


