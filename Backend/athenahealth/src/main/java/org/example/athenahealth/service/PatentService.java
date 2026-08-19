package org.example.athenahealth.service;

import org.example.athenahealth.utilities.Patients;

import java.util.List;

public interface PatentService {

    List<Patients> getAllPatient();

    Patients getPatientById(int id);

    String addPatient(Patients patients);

    String updatePatient(Patients patients);

    String deletePatient(int id);
}