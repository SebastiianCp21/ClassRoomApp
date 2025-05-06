package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Qualification;
import com.example.ApiClassRoom.repositories.IQualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService {
    @Autowired
    IQualificationRepository repository;

    public Qualification saveQualification(Qualification qualificationData) throws Exception {
        try {
            return this.repository.save(qualificationData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Qualification modifyQualification(Integer id, Qualification qualificationData) throws Exception {
        try {
            Optional<Qualification> searchedQualification = this.repository.findById(id);

            if (searchedQualification.isPresent()) {
                searchedQualification.get().setEvaluationDate(qualificationData.getEvaluationDate());
                searchedQualification.get().setGrade(qualificationData.getGrade());

                return this.repository.save(searchedQualification.get());
            } else {
                //No estaba
                throw new Exception("The qualification you are trying to modify does not exist in the database.");

            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR POR ID
    public Qualification searchQualificationById(Integer id) throws Exception {
        try {
            Optional<Qualification> qualificationToFind = this.repository.findById(id);
            if (qualificationToFind.isPresent()) {
                return qualificationToFind.get();
            } else {
                throw new Exception(MessagesAPI.QUALIFICATION_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR TODAS LAS CALIFICACIONES
    public List<Qualification> searchAllQualifications() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR CALIFICACIONES POR ESTUDIANTE
    public List<Qualification> searchQualificationsByStudent(Integer studentId) throws Exception {
        try {
            return this.repository.findByStudentId(studentId);
        } catch (Exception error) {
            throw new Exception("Error finding qualifications for student: " + error.getMessage());
        }
    }

    // BUSCAR CALIFICACIONES POR MATERIA
    public List<Qualification> searchQualificationsBySubject(Integer subjectId) throws Exception {
        try {
            return this.repository.findBySubjectId(subjectId);
        } catch (Exception error) {
            throw new Exception("Error finding qualifications for subject: " + error.getMessage());
        }
    }

    // ELIMINAR CALIFICACIÓN
    public boolean deleteQualification(Integer id) throws Exception {
        try {
            Optional<Qualification> qualificationToFind = this.repository.findById(id);
            if (qualificationToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.QUALIFICATION_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
