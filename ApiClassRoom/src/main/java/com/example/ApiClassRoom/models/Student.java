package com.example.ApiClassRoom.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column(nullable = false)
    private int grade;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Enrollment> enrollment;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Qualification> qualification;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Attendance> attendance;

    public Student() {
    }

    public Student(Integer id, int grade, LocalDate dateOfBirth, String address) {
        this.id = id;
        this.grade = grade;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
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
        return address;
    }

    public void setAddres(String addres) {
        this.address = addres;
    }
}
