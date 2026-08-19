package org.example.athenahealth.repository;

import org.example.athenahealth.utilities.PatientRow;
import org.example.athenahealth.utilities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepo {

    @Autowired
    private PatientRow patientRow;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get All Patients
    public List<Patients> getAllPatient() {

        String sql = " SELECT * FROM patient ";

        return jdbcTemplate.query(sql, patientRow);
    }

    // Add Patient
    public int addPatient(Patients patient) {

        String sql = "INSERT INTO patient(id, name, email, phoneNumber) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhoneNumber()
        );
    }

    //Induvial Patient
    public Patients getPatientById(int id) {

        String sql = "SELECT * FROM patient WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Patients(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getLong("phoneNumber")
                ),
                id
        );
    }

    // Update Patient
    public int updatePatient(Patients patient) {

        String sql = "UPDATE patient SET name=?, email=?, phoneNumber=? WHERE id=?";

        return jdbcTemplate.update(
                sql,
                patient.getName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getId()
        );
    }

    // Delete Patient
    public int deletePatient(int id) {

        String sql = "DELETE FROM patient WHERE id=?";

        return jdbcTemplate.update(sql, id);
    }
}