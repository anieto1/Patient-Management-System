package com.pm.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank(message =  "Name is required")
    @Size(max=100, message="Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message="Invalid email address")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max=100, message="Address must be less than 100 characters")
    private String address;

    @NotBlank(message = "Date of birth is required")
   // @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}", message="Invalid date of birth format. Use MM/DD/YYYY")
    private String dateOfBirth;
    
    @NotNull(message = "Registered date is required")
    private String registeredDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
    
}
