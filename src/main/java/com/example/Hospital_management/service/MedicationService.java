package com.example.Hospital_management.service;


import com.example.Hospital_management.entity.Appointment;
import com.example.Hospital_management.entity.Medication;
import com.example.Hospital_management.repository.AppointmentRepository;
import com.example.Hospital_management.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    private MedicationRepository medicationRepository;
    private AppointmentRepository appointmentRepository;

    // to get specific appointment by their id

    public Appointment findAppointmentById(Long appointment_id) {
        return appointmentRepository.findById(appointment_id).orElse(null);
    }

    //to save the medication details

    public void saveMedication(Medication medication) {
        medicationRepository.save(medication);
    }

    //to display medication by their id

    public Medication getMedicationById(Long medicationId) {
        return medicationRepository.findById(medicationId).orElse(null);
    }

    //to display all medication

    public List<Medication> getAllMedication(Long appointmentId) {
        return medicationRepository.findByAppointmentId(appointmentId);
    }

    // update the medication

    public void updateMedication(Long medicationId, Medication medication) {
        Medication existingMedication = getMedicationById(medicationId);
        if (existingMedication != null) {
            existingMedication.setMedicine_name(medication.getMedicine_name());
            existingMedication.setPrescribedDate(medication.getPrescribedDate());
            existingMedication.setDosage(medication.getDosage());
            existingMedication.setTime(medication.getTime());
            medicationRepository.save(existingMedication);
        }
    }

    //delete the medication

    public void deleteMedication(Long medicationId) {
        medicationRepository.deleteById(medicationId);
    }
}


