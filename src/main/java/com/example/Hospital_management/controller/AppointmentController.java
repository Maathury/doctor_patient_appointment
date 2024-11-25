package com.example.Hospital_management.controller;


import com.example.Hospital_management.entity.Appointment;
import com.example.Hospital_management.service.AppointmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    //display appointment list

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR', 'ROLE_PATIENT')")
    @GetMapping("/appointmentList")
    public String getAllAppointment(Model model){
        model.addAttribute("listOfAppointment",appointmentService.getAllAppointments());
        return "viewAppointment";
    }

    // save appointment

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.bookAppointment(appointment);
        return "viewAppointment";
    }

    //cancel appointment by id
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @GetMapping("cancelAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") Long id) {

        appointmentService.cancelAppointment(id);
        return "redirect:/viewAppointment";
    }
}
