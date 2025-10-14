package com.coding.bappa.LearningRESTAPIs.service.Impl;

import com.coding.bappa.LearningRESTAPIs.dto.PatientDto;
import com.coding.bappa.LearningRESTAPIs.entity.Patient;
import com.coding.bappa.LearningRESTAPIs.repository.PatientRepository;
import com.coding.bappa.LearningRESTAPIs.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper){
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        patient = patientRepository.save(patient);
        return modelMapper.map(patient, PatientDto.class);
    }
}
