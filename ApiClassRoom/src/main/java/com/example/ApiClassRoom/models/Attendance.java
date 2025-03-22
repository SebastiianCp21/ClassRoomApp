package com.example.ApiClassRoom.models;

import com.example.ApiClassRoom.helpers.AttendanceStatus;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Attendance {
    private Integer id;
    private LocalDate date;
    private AttendanceStatus status;

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
