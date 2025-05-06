package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepository repository;

    public Course saveCourse(Course courseData)throws Exception{
        try {
            return this.repository.save(courseData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Course modifyCourse (Integer id, Course courseData)throws Exception{
        try {
            Optional<Course>searchedCourse=this.repository.findById(id);
            if (searchedCourse.isPresent()){
                searchedCourse.get().setName(courseData.getName());
                return this.repository.save(searchedCourse.get());
            }else{
                //No estaba
                throw new Exception("The course you are trying to modify does not exist in the database.");

            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // 1. Buscar por ID
    public Course searchCourseById(Integer id) throws Exception {
        try {
            Optional<Course> courseToFind = this.repository.findById(id);
            if (courseToFind.isPresent()) {
                return courseToFind.get();
            } else {
                throw new Exception(MessagesAPI.COURSE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // 2. Buscar todos
    public List<Course> searchAllCourses() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // 3. Eliminar
    public boolean deleteCourse(Integer id) throws Exception {
        try {
            Optional<Course> courseToFind = this.repository.findById(id);
            if (courseToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.COURSE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
