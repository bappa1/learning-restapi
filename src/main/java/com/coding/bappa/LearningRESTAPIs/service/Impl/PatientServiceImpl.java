package com.coding.bappa.LearningRESTAPIs.service.Impl;

import com.coding.bappa.LearningRESTAPIs.dto.PatientDto;
import com.coding.bappa.LearningRESTAPIs.entity.Patient;
import com.coding.bappa.LearningRESTAPIs.exception.PatientNotFoundException;
import com.coding.bappa.LearningRESTAPIs.repository.PatientRepository;
import com.coding.bappa.LearningRESTAPIs.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(p-> modelMapper.map(p, PatientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientBId(Long id) {
        Patient patient = patientRepository.findById(id)
                //.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient is not found with this id:" +id));
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
        return modelMapper.map(patient, PatientDto.class);
    }
    /*@Override
    public PatientDto getPatientBId(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID " + id + " not found"));

        // Convert to DTO (assuming you have a mapper or manual conversion)
        PatientDto dto = new PatientDto();
        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setEmail(patient.getEmail());
        return dto;
    }*/

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient is not found with this id:" +id));
        modelMapper.map(patientDto, existing);
        Patient updated = patientRepository.save(existing);
        return modelMapper.map(updated, PatientDto.class);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient is not found with this id:"+id));
        patientRepository.delete(patient);
    }
}
