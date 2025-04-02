package com.pm.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.respository.PatientRepository;

@Service

public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        // Retrieve all patients from the database using the repository
        List<Patient> patients = patientRepository.findAll();

        // Convert the list of Patient entities to PatientResponseDTOs using stream
        // This maps each Patient object to a DTO using the PatientMapper
        List<PatientResponseDTO> patientResponseDTOs = patients.stream()
        .map(PatientMapper::toDTO).toList();

        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
