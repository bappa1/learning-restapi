package com.coding.bappa.LearningRESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String bloodGroup;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
