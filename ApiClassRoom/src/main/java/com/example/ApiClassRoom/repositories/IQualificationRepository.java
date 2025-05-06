package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQualificationRepository extends JpaRepository<Qualification, Integer> {
    // Buscar por ID de estudiante
    List<Qualification> findByStudentId(Integer studentId);

    // Buscar por ID de materia
    List<Qualification> findBySubjectId(Integer subjectId);
}
