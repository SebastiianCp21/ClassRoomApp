package com.example.ApiClassRoom.models;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Enrollment {
    private Integer id;
    private LocalDate enrollmentDate;

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
