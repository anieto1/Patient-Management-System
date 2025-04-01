package com.pm.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank
    @Size(max=100, message="Name must be less than 100 characters")
    private String name;


    @NotBlank
    @Email(message="Invalid email address")
    private String email;

    @NotBlank
    @Size(max=100, message="Address must be less than 100 characters")
    private String address;

    @NotBlank
    @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}", message="Invalid date of birth format. Use MM/DD/YYYY")
    private String dateOfBirth;
    
    
    
    
}
