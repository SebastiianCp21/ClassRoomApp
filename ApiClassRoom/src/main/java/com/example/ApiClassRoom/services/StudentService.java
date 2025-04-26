package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStudentRepository repository;

    public Student saveStudent(Student studentData)throws Exception{
        try {
            return this.repository.save(studentData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
