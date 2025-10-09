package com.coding.bappa.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be length of 3 to 30 characters")
    private String name;
    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
