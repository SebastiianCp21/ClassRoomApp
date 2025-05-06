package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Enrollment;
import com.example.ApiClassRoom.repositories.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Enrollment searchEnrollmentById(Integer id) throws Exception {
        try {
            Optional<Enrollment> enrollmentToFind = this.repository.findById(id);
            if (enrollmentToFind.isPresent()) {
                return enrollmentToFind.get();
            } else {
                throw new Exception(MessagesAPI.ENROLLMENT_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //  BUSCAR TODOS
    public List<Enrollment> searchAllEnrollments() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // 3. ELIMINAR
    public boolean deleteEnrollment(Integer id) throws Exception {
        try {
            Optional<Enrollment> enrollmentToFind = this.repository.findById(id);
            if (enrollmentToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.ENROLLMENT_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}