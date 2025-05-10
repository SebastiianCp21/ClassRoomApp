package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Qualification;
import com.example.ApiClassRoom.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualifications")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    // Guardar una nueva calificación
    @PostMapping("/save")
    public ResponseEntity<?> saveQualification(@RequestBody Qualification qualificationData) {
        try {
            Qualification savedQualification = qualificationService.saveQualification(qualificationData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedQualification);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Actualizar una calificación existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQualification(@PathVariable Integer id, @RequestBody Qualification qualificationData) {
        try {
            Qualification updatedQualification = qualificationService.modifyQualification(id, qualificationData);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedQualification);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Obtener una calificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getQualificationById(@PathVariable Integer id) {
        try {
            Qualification qualification = qualificationService.searchQualificationById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(qualification);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Obtener todas las calificaciones
    @GetMapping
    public ResponseEntity<?> getAllQualifications() {
        try {
            List<Qualification> qualifications = qualificationService.searchAllQualifications();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(qualifications);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    // Obtener calificaciones por estudiante
    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getQualificationsByStudent(@PathVariable Integer studentId) {
        try {
            List<Qualification> qualifications = qualificationService.searchQualificationsByStudent(studentId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(qualifications);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Obtener calificaciones por materia
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<?> getQualificationsBySubject(@PathVariable Integer subjectId) {
        try {
            List<Qualification> qualifications = qualificationService.searchQualificationsBySubject(subjectId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(qualifications);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar una calificación
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQualification(@PathVariable Integer id) {
        try {
            boolean isDeleted = qualificationService.deleteQualification(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Qualification deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete qualification");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}