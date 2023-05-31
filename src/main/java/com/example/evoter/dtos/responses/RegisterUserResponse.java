package com.example.evoter.dtos.responses;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String userId;
    private String name;
    private String emailAddress;
    private int age;
}
