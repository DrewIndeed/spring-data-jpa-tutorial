package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // simple methods
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String targetContaining);

    // using @Query
    @Query("select s from Student s where s.emailId = ?1") // ?1 means first parameter
    Student getStudentByEmailAddress(String emailId);

    // IMPORTANT:  About 'from Student', Student is the class that we create in Java
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}
