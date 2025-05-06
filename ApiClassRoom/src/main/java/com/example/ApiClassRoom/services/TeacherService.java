package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired //Inyeccion de dependencias
    ITeacherRepository repository;

    //En el servicio implementamos los metodos
    //qu necesitamos segun los servicios a ofrecer

    //GUARDAR
    public Teacher saveTeacher(Teacher teacherData) throws Exception {
        try {
            return this.repository.save(teacherData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR

    public Teacher modifyTeacher(Integer id, Teacher teacherData) throws Exception {
        try {
            //Para modificar primero dbo buscar

            //JPA Me devuelve un dato opcional (Puede estar o no)
            Optional<Teacher> searchedTeacher = this.repository.findById(id);

            //Apenas lo busques, pregunta si estaba
            if (searchedTeacher.isPresent()) {
                //Modifique ps
                searchedTeacher.get().setSpecialization(teacherData.getSpecialization());//MOdificando un dato viejo
                return this.repository.save(searchedTeacher.get());
            } else {
                //No estaba
                throw new Exception(MessagesAPI.TEACHER_NOT_FOUND.getText());

            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    //BUSCAR POR ID
    public Teacher searchTeacherById(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherWantToFind = this.repository.findById(id);
            if (teacherWantToFind.isPresent()) {
                //retorno el docente que busco
                return teacherWantToFind.get();
            } else {
                //mensaje de que no esta
                throw new Exception(MessagesAPI.TEACHER_NOT_FOUND.getText());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Teacher> searchAllTeachers()throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteTeacher (Integer id)throws Exception {
        try {
            Optional<Teacher> teacherWantToFind = this.repository.findById(id);
            if (teacherWantToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.TEACHER_NOT_FOUND.getText());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
