package com.example.Hospital_management.repository;

import com.example.Hospital_management.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicationRepository extends JpaRepository< Medication, Long> {

    @Query("SELECT m FROM Medication m WHERE m.appointment.appointment_id = :appointment_id")
    List<Medication> findByAppointmentId(Long appointment_id);



}
