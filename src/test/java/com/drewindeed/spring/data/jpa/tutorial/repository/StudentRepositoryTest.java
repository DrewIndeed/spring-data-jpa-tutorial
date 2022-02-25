package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Guardian;
import com.drewindeed.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Andrew")
                .lastName("Le")
                .emailId("truongan@gmail.com")
                //.guardianEmail("gda@gmail.com")
                //.guardianMobile("888888888")
                //.guardianName("Uzi Vert")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        // create guardian instance
        Guardian guardian = Guardian
                .builder()
                .email("guarjoey@gmail.com")
                .name("Joey")
                .mobile("686868688")
                .build();

        // create student instance
        Student student = Student
                .builder()
                .firstName("Anderson")
                .lastName("Volta")
                .emailId("anderaron22@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}