package com.example.Hospital_management.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Doctor {

    //doctor details

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  doctor_id;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null")
    private String doctor_name;

    @Column(nullable = false)
    @NotNull
    private String specialization;

    @Column(nullable = false)
    @NotNull
    private String availableTime; //morning 10.00 am-1.00 pm

}
