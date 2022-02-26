package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Course;
import com.drewindeed.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        // course instance
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(14)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(12)
                .build();

        // teacher instance
        Teacher teacher = Teacher.builder()
                .firstName("Duy")
                .lastName("Nguyen")
                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}