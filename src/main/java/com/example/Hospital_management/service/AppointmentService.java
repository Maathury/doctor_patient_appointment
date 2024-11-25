package com.example.Hospital_management.service;


import com.example.Hospital_management.entity.Appointment;
import com.example.Hospital_management.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    //to book appointments

    public void bookAppointment(Appointment appointment){

        Optional<Appointment> myAppointment=appointmentRepository.findById(appointment.getAppointment_id());
        if(myAppointment.isEmpty()){
            appointmentRepository.save(appointment);
        }else{
            throw new IllegalStateException("Appointment with id already present");
        }
    }

    // to display all appointments

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    //to cancel appointment bu id

    public void cancelAppointment(Long id){
        appointmentRepository.deleteById(id);
    }


}
