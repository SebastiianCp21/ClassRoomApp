package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
