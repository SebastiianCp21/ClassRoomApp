package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // **Guardar un nuevo curso**
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Course courseData) {
        try {
            Course savedCourse = courseService.saveCourse(courseData);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedCourse);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // **Obtener un curso por ID**
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            Course course = courseService.searchCourseById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(course);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // **Listar todos los cursos**
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(courseService.searchAllCourses());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }

    // **Eliminar un curso**
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = courseService.deleteCourse(id);
            if (isDeleted) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Course deleted successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete course");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}