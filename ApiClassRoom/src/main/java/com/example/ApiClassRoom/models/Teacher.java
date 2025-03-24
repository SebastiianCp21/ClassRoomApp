package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer id;
    @Column(nullable = false, length = 100)
    private String specialization;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Course> courses;

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
