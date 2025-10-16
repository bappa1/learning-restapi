package com.coding.bappa.LearningRESTAPIs.repository;

import com.coding.bappa.LearningRESTAPIs.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByCity(String city);
}
