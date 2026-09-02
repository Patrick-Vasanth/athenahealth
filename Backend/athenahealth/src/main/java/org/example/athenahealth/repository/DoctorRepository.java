package org.example.athenahealth.repository;

import org.example.athenahealth.utilities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
