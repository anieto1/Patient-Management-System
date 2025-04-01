package com.pm.patient_service.mapper;

import java.time.format.DateTimeFormatter;

import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth() != null ? 
            patient.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE) : null);
        patientResponseDTO.setRegisteredDate(patient.getRegisteredDate() != null ? 
            patient.getRegisteredDate().format(DateTimeFormatter.ISO_LOCAL_DATE) : null);
        return patientResponseDTO;
    }
}
