package com.drewindeed.spring.data.jpa.tutorial.repository;

import com.drewindeed.spring.data.jpa.tutorial.entity.Course;
import com.drewindeed.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        // pageable objects
        Pageable firstPageWithOneRecords = PageRequest.of(0, 1);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 3);

        // courses lists
        List<Course> courseListFirst = courseRepository.findAll(firstPageWithOneRecords).getContent();
        List<Course> courseListSecond = courseRepository.findAll(secondPageWithThreeRecords).getContent();

        // total elements number
        long totalElementsFirst = courseRepository.findAll(firstPageWithOneRecords).getTotalElements();
        long totalElementsSecond = courseRepository.findAll(secondPageWithThreeRecords).getTotalElements();

        // total pages number
        long totalPagesFirst = courseRepository.findAll(firstPageWithOneRecords).getTotalPages();
        long totalPagesSecond = courseRepository.findAll(secondPageWithThreeRecords).getTotalPages();

        // print
        System.out.println("First Page");
        System.out.println(courseListFirst);
        System.out.println(totalElementsFirst);
        System.out.println(totalPagesFirst);
        System.out.println("Second Page");
        System.out.println(courseListSecond);
        System.out.println(totalElementsSecond);
        System.out.println(totalPagesSecond);
    }

    @Test
    public void findAllSorting() {
        // pageable objects
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("title").descending().and(Sort.by("credit")));

        // get list of course based on sorting objects
        List<Course> courseSortFirst = courseRepository.findAll(sortByTitle).getContent();
        List<Course> courseSortSecond = courseRepository.findAll(sortByCreditDesc).getContent();
        List<Course> courseSortThird = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        // printing
        System.out.println(courseSortFirst);
        System.out.println(courseSortSecond);
        System.out.println(courseSortThird);
    }
}