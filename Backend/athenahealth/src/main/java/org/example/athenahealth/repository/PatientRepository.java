package org.example.athenahealth.repository;

import org.example.athenahealth.utilities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

