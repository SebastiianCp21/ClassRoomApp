package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Enrollment;
import com.example.ApiClassRoom.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Guardar una nueva matrícula
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Enrollment enrollmentData) {
        try {
            Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollmentData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedEnrollment);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Obtener una matrícula por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            Enrollment enrollment = enrollmentService.searchEnrollmentById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(enrollment);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Obtener todas las matrículas
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(enrollmentService.searchAllEnrollments());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    // Eliminar una matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = enrollmentService.deleteEnrollment(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Enrollment deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete enrollment");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}
