package com.example.Hospital_management.controller;

import com.example.Hospital_management.repository.DoctorRepository;
import com.example.Hospital_management.service.DoctorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DoctorController {

    private DoctorService doctorService ;

    //display all doctors

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    @GetMapping("/viewDoctor")
    public String allDoctors(Model model){
        model.addAttribute("listOfDoctor",doctorService.getAllDoctors());
        return "viewDoctor";
    }
}
