package org.example.athenahealth.utilities;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class PatientRow implements RowMapper<Patients> {
    @Override
    public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Patients(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getDouble("phoneNumber"));
    }
}
