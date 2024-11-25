package com.example.Hospital_management.repository;

import com.example.Hospital_management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


}
