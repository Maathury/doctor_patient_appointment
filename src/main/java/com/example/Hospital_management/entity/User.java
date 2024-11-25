package com.example.Hospital_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {

    //Patient or user details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  user_id;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null")
    private String username;

    @Email
    @Size(min = 4, max = 25, message = "Please check the size")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min=0,max=10, message = "Please check the number")
    @Column(nullable = false, unique = true)
    private long user_phoneNO;

    @NotNull(message="password can't be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Please check criteria for password")
    @Size(min = 8,max = 25 , message= "min length of password is 8")
    private String password;


    private String roles; //for authorisation we provide Role_Patient and Role_Doctor


}
