package org.example.athenahealth.service;

import org.example.athenahealth.repository.PatientRepImpl;
import org.example.athenahealth.repository.PatientRepo;
import org.example.athenahealth.utilities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatentService {

    @Autowired
    private PatientRepImpl patientRepo;

    public PatientServiceImpl(PatientRepImpl patientRepo) {
        this.patientRepo=patientRepo;
    }


    @Override
    public List<Patients> getAllPatient() {
//        return patientRepo.getAllPatient();
        return patientRepo.findAll();
    }

    @Override
    public String addPatient(Patients patients) {

//        int rows = patientRepo.addPatient(patients);
//
//        return rows > 0 ? "Patient Added Successfully"
//                : "Patient Not Added";

        Patients patient = patientRepo.save(patients);
        return patient.getId() > 0 ? "Patient Added Successfully"
                : "Patient Not Added";
    }

    @Override
    public Patients getPatientById(int id) {
//        return patientRepo.getPatientById(id);

        return patientRepo.findById(id).orElse(null);
    }

    @Override
    public String updatePatient(Patients patients) {
//
//        int rows = patientRepo.updatePatient(patients);
//
//        return rows > 0 ? "Patient Updated Successfully"
//                : "Patient Not Found";
        int id = patientRepo.save(patients).getId();
        return id > 0 ? "Patient Updated Successfully"
                : "Patient Not Found";
    }

    @Override
    public String deletePatient(int id) {

//        int rows = patientRepo.deletePatient(id);
//
//        return rows > 0 ? "Patient Deleted Successfully"
//                : "Patient Not Found";

        patientRepo.deleteById(id);
        return "Patient Deleted Successfully";
    }
}