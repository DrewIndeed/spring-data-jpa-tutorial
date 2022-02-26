package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Course;
import com.drewindeed.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository materialRepository;

    @Test
    public void saveCourseMaterial() {
        // course instance
        Course course = Course.builder()
                .title("DSA")
                .credit(12)
                .build();

        // course material instance
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.matehere.com")
                .course(course)
                .build();

        // ERROR: this should not work if course has not been saved
        // -> Need CASCADING
        materialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> materialList = materialRepository.findAll();
        System.out.println("materialList = " + materialList);
    }
}