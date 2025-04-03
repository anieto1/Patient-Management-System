package com.pm.patient_service.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        if (patient == null) return null;
        
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId() != null ? patient.getId().toString() : null);
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth() != null ? 
            patient.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE) : null);
        patientResponseDTO.setRegisteredDate(patient.getRegisteredDate() != null ? 
            patient.getRegisteredDate().format(DateTimeFormatter.ISO_LOCAL_DATE) : null);
        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        if (patientRequestDTO == null) return null;
        
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.now());

        return patient;
    }
}
/**
 * Mapper class to handle conversion between Patient entity and DTOs.
 * This separation of concerns helps isolate the internal domain model (Patient)
 * from the external representation (DTOs) used for data transfer.
 * Using a mapper:
 * - Prevents tight coupling between layers
 * - Allows entity and DTO to evolve independently
 * - Provides a clean way to handle data transformations
 * - Helps maintain a clear separation between domain model and API contract
 */
