package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Course;
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
}