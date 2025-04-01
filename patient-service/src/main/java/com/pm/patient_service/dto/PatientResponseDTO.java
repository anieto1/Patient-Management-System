package com.pm.patient_service.dto;

public class PatientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
    private String registeredDate;
    
    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
