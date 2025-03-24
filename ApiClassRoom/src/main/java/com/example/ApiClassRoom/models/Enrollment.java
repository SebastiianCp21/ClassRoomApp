package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Integer id;
    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "student_id")
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_fk", referencedColumnName = "course_id")
    @JsonBackReference
    Course course;

    public Enrollment() {
    }

    public Enrollment(Integer id, LocalDate enrollmentDate) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
