package com.example.Hospital_management.service;


import com.example.Hospital_management.entity.User;
import com.example.Hospital_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    //to register the patient details and save it in database

    public void registerPatient(String username, String email, String password) {
        if (userRepository.findByUsernameOrEmail(username, email).isPresent()) {
            throw new IllegalArgumentException("Username or Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User newPatient = new User();
        newPatient.setUsername(username);
        newPatient.setEmail(email);
        newPatient.setPassword(encodedPassword);
        newPatient.setRoles("ROLE_PATIENT");
        userRepository.save(newPatient);

    }

}
