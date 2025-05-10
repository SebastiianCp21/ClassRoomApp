package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Subject;
import com.example.ApiClassRoom.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService service;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Subject subjectData){
        try {
            Subject savedSubject = this.service.saveSubject(subjectData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedSubject);
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para actualizar una materia
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Subject subjectData) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.modifySubject(id, subjectData));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para buscar materia por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchSubjectById(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para listar todas las materias
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchAllSubjects());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    // Controlador para eliminar una materia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = this.service.deleteSubject(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Subject deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete subject");
            }
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }
}
