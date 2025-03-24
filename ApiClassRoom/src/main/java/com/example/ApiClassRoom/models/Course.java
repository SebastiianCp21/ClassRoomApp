package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_fk", referencedColumnName = "teacher_id")
    @JsonBackReference
    Teacher teacher;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Subject> subject;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Enrollment> enrollment;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendance;

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
