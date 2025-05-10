package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Attendance;
import com.example.ApiClassRoom.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Registrar nueva asistencia
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Attendance attendanceData) {
        try {
            Attendance savedAttendance = attendanceService.saveAttendance(attendanceData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedAttendance);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Obtener asistencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            Attendance attendance = attendanceService.searchAttendanceById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(attendance);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Listar todas las asistencias
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(attendanceService.searchAllAttendances());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    // Eliminar asistencia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = attendanceService.deleteAttendance(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Attendance deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete attendance");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}