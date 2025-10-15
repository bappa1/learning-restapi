package com.coding.bappa.LearningRESTAPIs.controller;

import com.coding.bappa.LearningRESTAPIs.dto.PatientDto;
import com.coding.bappa.LearningRESTAPIs.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    //POST DATA (Save Patient)
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto){
        PatientDto created = patientService.createPatient(patientDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //Get All Patient
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        List<PatientDto> patients = patientService.getAllPatient();
        return ResponseEntity.ok(patients);
    }
    //Patient By Id
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        PatientDto patient = patientService.getPatientBId(id);
        return ResponseEntity.ok(patient);
    }
    //Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto){
        PatientDto  updated = patientService.updatePatient(id, patientDto);
        return ResponseEntity.ok(updated);
    }
    //Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
