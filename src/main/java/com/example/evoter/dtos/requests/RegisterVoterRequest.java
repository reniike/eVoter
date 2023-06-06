package com.example.evoter.dtos.requests;

import lombok.Data;

@Data
public class RegisterVoterRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private int age;
}
