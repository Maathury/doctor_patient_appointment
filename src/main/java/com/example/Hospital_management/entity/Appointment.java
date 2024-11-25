package com.example.Hospital_management.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    //getting the appointment details

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  appointment_id;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null")
    private String patientName;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null")
    private String doctor_name;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private  Doctor doctor;

    @Column(nullable = false)
    private LocalDateTime appointment_date;


}
