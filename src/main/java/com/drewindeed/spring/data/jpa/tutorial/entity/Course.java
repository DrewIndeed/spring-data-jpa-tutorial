package com.drewindeed.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    // From Uni to Bi directional here
    @OneToOne(
            mappedBy = "course" // 'course' is the name of the attribute on CourseMaterial class
    )
    private CourseMaterial courseMaterial;
}
