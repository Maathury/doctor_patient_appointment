package com.example.Hospital_management.controller;


import com.example.Hospital_management.entity.Appointment;
import com.example.Hospital_management.entity.Medication;
import com.example.Hospital_management.service.MedicationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class MedicationController {

    private MedicationService medicationService;


    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    @GetMapping("/showMedications")
    public String showMedication(@RequestParam Long appointmentId, Model model) {

        Appointment appointment = medicationService.findAppointmentById(appointmentId);
        if (appointment == null) {
            model.addAttribute("errorMessage", "Appointment not found!  " + appointmentId);
            return "viewMedicine";
        }
        model.addAttribute("appointment", appointment);
        return "viewMedicine"; // Show medication details for the appointment ID
    }

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    @GetMapping("/medications/{appointmentId}")
    public String viewMedicationsPage(@PathVariable Long appointmentId, Model model) {
        Appointment appointment = medicationService.findAppointmentById(appointmentId);

        List<Medication> medications = medicationService.getAllMedication(appointmentId);
        model.addAttribute("appointment", appointment);
        model.addAttribute("medicine", medications);
        model.addAttribute("appointmentId", appointmentId);
        return "medication";
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/addNewMedicine/{appointmentId}")
    public String addNewMedicine(Model model){
        Medication medication = new Medication();
        model.addAttribute("medication", medication);
        return "newMedicine";
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/saveMedication/{appointmentId}")
    public String saveMedicine(@PathVariable Long appointmentId,@ModelAttribute("medication") Medication medication){

        medicationService.saveMedication(medication);
        return "redirect:/medication" + appointmentId;

    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/UpdateMedicine//{appointmentId}/{medicationId}")
    public String updateMedicine(@PathVariable Long appointmentId, @PathVariable Long medicationId, Model model){
        Medication medicine = medicationService.getMedicationById(medicationId);
        model.addAttribute("medication", medicine);
        return "updateMedicine" + appointmentId;
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("deleteMedicine/{appointmentId}/{medicationId}")
    public String deleteMedicine(@PathVariable Long appointmentId, @PathVariable Long medicationId) {

        medicationService.deleteMedication(medicationId);
        return "redirect:/medication";
    }
}
