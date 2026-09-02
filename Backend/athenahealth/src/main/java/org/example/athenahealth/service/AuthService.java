package org.example.athenahealth.service;


import org.example.athenahealth.dto.LoginRequest;
import org.example.athenahealth.dto.RegisterRequest;
import org.example.athenahealth.repository.DoctorRepository;
import org.example.athenahealth.repository.PatientRepository;
import org.example.athenahealth.repository.UserRepository;
import org.example.athenahealth.utilities.Doctor;
import org.example.athenahealth.utilities.Patient;
import org.example.athenahealth.utilities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String register(RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists";
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        User.Role role = request.getRole();

        user.setRole(role);

        User savedUser = userRepository.save(user);

        if (role == User.Role.DOCTOR) {

            Doctor doctor = new Doctor();

            doctor.setName(request.getName());
            doctor.setEmail(request.getEmail());
            doctor.setPhone(request.getPhone());
            doctor.setUser(savedUser);

            doctorRepository.save(doctor);

        } else if (role == User.Role.PATIENT) {

            Patient patient = new Patient();

            patient.setName(request.getName());
            patient.setEmail(request.getEmail());
            patient.setPhone(request.getPhone());
            patient.setUser(savedUser);

            patientRepository.save(patient);
        }

        return "Registration successful";
    }

    public String login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return "Invalid password";
        }

        return "Login successful. Role: " + user.getRole();
    }
}