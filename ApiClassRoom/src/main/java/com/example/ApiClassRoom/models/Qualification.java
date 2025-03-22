package com.example.ApiClassRoom.models;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Qualification {
    private Integer id;
    private float grade;
    private LocalDate evaluationDate;

    public Qualification() {
    }

    public Qualification(Integer id, float grade, LocalDate evaluationDate) {
        this.id = id;
        this.grade = grade;
        this.evaluationDate = evaluationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
