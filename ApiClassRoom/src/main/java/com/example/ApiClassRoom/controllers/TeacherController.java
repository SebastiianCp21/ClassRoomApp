package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher clientSentData){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveTeacher(clientSentData));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());

        }
    }
    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Teacher teacherData) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.modifyTeacher(id, teacherData));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchTeacherById(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.searchAllTeachers());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = this.service.deleteTeacher(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Teacher deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete teacher");
            }
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorAPI.getMessage());
        }
    }
}

