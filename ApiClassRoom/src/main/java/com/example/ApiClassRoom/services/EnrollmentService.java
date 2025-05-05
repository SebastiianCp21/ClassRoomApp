package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Enrollment;
import com.example.ApiClassRoom.repositories.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentService {
    @Autowired
    IEnrollmentRepository repository;

    public Enrollment saveEnrollment(Enrollment enrollmentData) throws Exception {
        try {
            return this.repository.save(enrollmentData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Enrollment modifyEnrollment(Integer id, Enrollment enrollmentData) throws Exception {
        try {
            Optional<Enrollment> searchedEnrollment = this.repository.findById(id);

            if (searchedEnrollment.isPresent()) {
                searchedEnrollment.get().setEnrollmentDate(enrollmentData.getEnrollmentDate());
                return this.repository.save(searchedEnrollment.get());
            } else {
                //No estaba
                throw new Exception("The enrollment you are trying to modify does not exist in the database.");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}