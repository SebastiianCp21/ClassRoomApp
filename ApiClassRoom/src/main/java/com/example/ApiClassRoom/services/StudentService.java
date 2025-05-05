package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw new Exception("The student you are trying to modify does not exist in the database.");

            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
