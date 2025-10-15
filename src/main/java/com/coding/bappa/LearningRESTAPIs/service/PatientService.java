package com.coding.bappa.LearningRESTAPIs.service;

import com.coding.bappa.LearningRESTAPIs.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    List<PatientDto> getAllPatient();
    PatientDto getPatientBId(Long id);
    PatientDto updatePatient(Long id, PatientDto patientDto);
    void deletePatient(Long id);
}