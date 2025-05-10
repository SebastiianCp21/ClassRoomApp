package com.example.ApiClassRoom.controllers;


import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        UserService service;

        // Controlador para guardar usuario
        @PostMapping
        public ResponseEntity<?> save(@RequestBody User clientSentData) {
            try {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(this.service.saveUser(clientSentData));
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
            }
        }

        // Controlador para modificar usuario
        @PutMapping("/{id}")
        public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User userData) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.service.modifyUser(id, userData));
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(errorAPI.getMessage());
            }
        }

        // Controlador para buscar usuario por id
        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable Integer id) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.service.searchUserById(id));
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
            }
        }

        // Controlador para buscar todos los usuarios
        @GetMapping
        public ResponseEntity<?> findAll() {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.service.searchAllUsers());
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
            }
        }

        // Controlador para eliminar usuario
        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {
            try {
                boolean isDeleted = this.service.deleteUser(id);
                if (isDeleted) {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body("User deleted successfully");
                } else {
                    return ResponseEntity
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to delete user");
                }
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(errorAPI.getMessage());
            }
        }
    }

