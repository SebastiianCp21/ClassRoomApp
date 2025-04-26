package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQualificationRepository extends JpaRepository<Qualification, Integer> {
}
