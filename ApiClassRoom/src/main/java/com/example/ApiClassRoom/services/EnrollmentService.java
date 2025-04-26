package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Enrollment;
import com.example.ApiClassRoom.repositories.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    @Autowired
    IEnrollmentRepository repository;

    public Enrollment saveEnrollment(Enrollment enrollmentData)throws Exception{
        try {
            return this.repository.save(enrollmentData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
