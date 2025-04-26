package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Subject;
import com.example.ApiClassRoom.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    ISubjectRepository repository;

    //GUARDAR
    public Subject saveSubject(Subject subjectData) throws Exception{
        try {
            return this.repository.save(subjectData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
