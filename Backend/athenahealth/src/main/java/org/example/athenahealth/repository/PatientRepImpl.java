package org.example.athenahealth.repository;

import org.example.athenahealth.utilities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepImpl  extends JpaRepository<Patients, Integer> {
}
