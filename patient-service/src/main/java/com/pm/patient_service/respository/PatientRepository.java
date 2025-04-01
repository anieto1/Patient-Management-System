package com.pm.patient_service.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.patient_service.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    
    
}
