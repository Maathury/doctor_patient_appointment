package com.example.Hospital_management.controller;

import com.example.Hospital_management.service.DoctorService;
import com.example.Hospital_management.service.MedicationService;
import com.example.Hospital_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
    private UserService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicationService medicationService;

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
