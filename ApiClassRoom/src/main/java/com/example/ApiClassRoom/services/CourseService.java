package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
