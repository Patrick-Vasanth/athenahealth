package org.example.athenahealth.controller;

//import org.springframework.stereotype.Controller;
import org.example.athenahealth.service.PatentService;
import org.example.athenahealth.service.PatientServiceImpl;
import org.example.athenahealth.utilities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/patient")
public class PatientController {


    @Autowired
    private PatentService patientService;

    public PatientController(PatientServiceImpl patientService){
        this.patientService=patientService;
    }

    // Get All Patients
    @GetMapping("/allPatient")
    public List<Patients> getPatients() {
        return patientService.getAllPatient();
    }

    // Add Patient
    @PostMapping("/addPatient")
    public String addPatient(@RequestBody Patients patients) {
        return patientService.addPatient(patients);
    }

    //Individual Patient
    @GetMapping("/uniquePatient/{id}")
    public Patients getIndividualPatient(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    // Update Patient
    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patients patients) {
        return patientService.updatePatient(patients);
    }

    // Delete Patient
    @DeleteMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable int id) {
        return patientService.deletePatient(id);
    }





}
