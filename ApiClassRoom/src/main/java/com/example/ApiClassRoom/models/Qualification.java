package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Qualifications")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualification_id")
    private Integer id;
    @Column(nullable = false)
    private float grade;
    @Column(nullable = false)
    private LocalDate evaluationDate;


    @ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "student_id")
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name = "subject_fk", referencedColumnName = "subject_id")
    @JsonBackReference
    Subject subject;

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
