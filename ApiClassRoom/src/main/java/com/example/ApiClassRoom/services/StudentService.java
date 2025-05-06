package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepository repository;

    public Student saveStudent(Student studentData) throws Exception {
        try {
            return this.repository.save(studentData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Student modifyStudent(Integer id, Student studentData) throws Exception {
        try {
            Optional<Student> searchedStudent = this.repository.findById(id);

            if (searchedStudent.isPresent()) {
                searchedStudent.get().setAddres(studentData.getAddres());
                searchedStudent.get().setGrade(studentData.getGrade());
                searchedStudent.get().setDateOfBirth(studentData.getDateOfBirth());

                return this.repository.save(searchedStudent.get());
            } else {
                //No estaba
                throw new Exception(MessagesAPI.STUDENT_NOT_FOUND.getText());

            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR POR ID
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentToFind = this.repository.findById(id);
            if (studentToFind.isPresent()) {
                return studentToFind.get();
            } else {
                throw new Exception(MessagesAPI.STUDENT_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<Student> searchAllStudents() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // ELIMINAR
    public boolean deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentToFind = this.repository.findById(id);
            if (studentToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.STUDENT_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
