package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Qualification;
import com.example.ApiClassRoom.repositories.IQualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationService {
    @Autowired
    IQualificationRepository repository;

    public Qualification saveQualification(Qualification qualificationData)throws Exception{
        try {
            return this.repository.save(qualificationData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
