package com.example.ApiClassRoom.models;

import jakarta.persistence.Entity;

@Entity
public class Teacher {
    private Integer id;
    private String specialization;

    public Teacher() {
    }

    public Teacher(Integer id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
