package com.example.ApiClassRoom.models;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Student {
    private Integer id;
    private int grade;
    private LocalDate dateOfBirth;
    private String addres;

    public Student() {
    }

    public Student(Integer id, int grade, LocalDate dateOfBirth, String addres) {
        this.id = id;
        this.grade = grade;
        this.dateOfBirth = dateOfBirth;
        this.addres = addres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
