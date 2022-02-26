package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Course;
import com.drewindeed.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        // teacher instance
        Teacher teacher = Teacher.builder()
                .firstName("Ukemasala")
                .lastName("Obu")
                .build();

        // course instance
        Course course = Course.builder()
                .title("Python")
                .credit(12)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}