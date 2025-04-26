package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    @Autowired //Inyeccion de dependencias
    ITeacherRepository repository;

    //En el servicio implementamos los metodos
    //qu necesitamos segun los servicios a ofrecer

    //GUARDAR
    public Teacher saveTeacher(Teacher teacherData)throws Exception{
        try{
            return this.repository.save(teacherData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR

    public Teacher modifyTeacher(Integer id, Teacher teacherData)throws Exception{
     try {
         //Para modificar primero dbo buscar

         //JPA Me devuelve un dato opcional (Puede estar o no)
         Optional<Teacher>searchedTeacher=this.repository.findById(id);

         //Apenas lo busques, pregunta si estaba
         if (searchedTeacher.isPresent()){
             //Modifique ps
             searchedTeacher.get().setSpecialization(teacherData.getSpecialization());//MOdificando un dato viejo
             return this.repository.save(searchedTeacher.get());
         }else{
             //No estaba
             throw new Exception("The user you are trying to modify does not exist in the database.");

         }

     }catch (Exception error){
         throw new Exception(error.getMessage());
     }
    }


    //BUSCAR POR ID

    //BUSCAR TODOS

    //ELIMINAR
}
