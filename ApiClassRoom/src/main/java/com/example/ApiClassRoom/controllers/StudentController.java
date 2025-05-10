package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    // Controlador para guardar un estudiante
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student studentData) {
        try {
            Student savedStudent = this.service.saveStudent(studentData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedStudent);
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para actualizar un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Student studentData) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.modifyStudent(id, studentData));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para buscar estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchStudentById(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para listar todos los estudiantes
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchAllStudents());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = this.service.deleteStudent(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Student deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete student");
            }
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }
}