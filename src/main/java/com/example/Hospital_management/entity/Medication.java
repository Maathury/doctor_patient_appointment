package com.example.Hospital_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Medication {

    //Medication details

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  medicine_id;

    @Column(nullable = false)
    @NotNull(message = "Medicine name can't be null")
    private String medicine_name;

    @Column(nullable = false)
    private LocalDateTime prescribedDate; //current date

    @Column(nullable = false)
    @NotNull(message = "dosage can't be null")
    private String dosage; //before or after food

    @Column(nullable = false)
    @NotNull(message = "time can't be null")
    private String time; //morning,afternoon,night

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
