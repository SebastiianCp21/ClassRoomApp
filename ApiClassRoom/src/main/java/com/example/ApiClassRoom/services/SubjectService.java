package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Subject;
import com.example.ApiClassRoom.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    ISubjectRepository repository;

    //GUARDAR
    public Subject saveSubject(Subject subjectData) throws Exception {
        try {
            return this.repository.save(subjectData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Subject modifySubject(Integer id, Subject subjectData) throws Exception {
        try {
            Optional<Subject> searchedSubject = this.repository.findById(id);

            if (searchedSubject.isPresent()) {
                searchedSubject.get().setName(subjectData.getName());
                return this.repository.save(searchedSubject.get());
            } else {
                throw new Exception("The subject you are trying to modify does not exist in the database.");
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }
}
