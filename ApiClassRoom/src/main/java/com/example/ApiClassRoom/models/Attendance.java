package com.example.ApiClassRoom.models;

import com.example.ApiClassRoom.helpers.AttendanceStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private AttendanceStatus status;

    @ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "student_id")
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_fk", referencedColumnName = "course_id")
    @JsonBackReference
    Course course;

    public Attendance() {
    }

    public Attendance(Integer id, LocalDate date, AttendanceStatus status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
