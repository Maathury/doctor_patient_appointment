package com.example.Hospital_management.service;


import com.example.Hospital_management.entity.Doctor;
import com.example.Hospital_management.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class DoctorService {

    private DoctorRepository doctorRepository;

    //to display all doctor details

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // to display specific doctor by their id

    public Doctor getDoctorById(Long id) {
        Optional<Doctor> doctorId = doctorRepository.findById(id);
        if(doctorId.isPresent()){
            return doctorId.get();
        }else{
            throw new RuntimeException("Doctor not found with id: " + id); //throw exception if id not found
        }
    }

}
