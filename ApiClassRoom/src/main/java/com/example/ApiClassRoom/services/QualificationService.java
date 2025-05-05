package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Qualification;
import com.example.ApiClassRoom.repositories.IQualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Qualification modifyQualification(Integer id, Qualification qualificationData)throws Exception{
        try {
            Optional<Qualification>searchedQualification=this.repository.findById(id);

            if (searchedQualification.isPresent()){
                searchedQualification.get().setEvaluationDate(qualificationData.getEvaluationDate());
                searchedQualification.get().setGrade(qualificationData.getGrade());

                return this.repository.save(searchedQualification.get());
            }else{
                //No estaba
                throw new Exception("The qualification you are trying to modify does not exist in the database.");

            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
