package com.coding.bappa.LearningRESTAPIs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "patients",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_patient_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_patient_phone", columnNames = "phone_number")
        },
        indexes = {
                @Index(name = "idx_patient_last_name", columnList = "last_name"),
                @Index(name = "idx_patient_city", columnList = "city")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Email
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "city", length = 100)
    private String city;
    @Column(name = "state", length = 100)
    private String state;
    @Column(name = "zip_code", length = 20)
    private String zipCode;
    @Column(name = "country", length = 100)
    private String country;
    @Column(name = "blood_group", length = 10)
    private String bloodGroup;
    @Column(name = "emergency_contact_name", length = 100)
    private String emergencyContactName;
    @Column(name = "emergency_contact_number", length = 15)
    private String emergencyContactNumber;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedAt;
}