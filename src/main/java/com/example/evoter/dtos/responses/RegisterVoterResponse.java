package com.example.evoter.dtos.responses;

import lombok.Data;

@Data
public class RegisterVoterResponse {
    private String voterId;
    private String name;
    private String emailAddress;
    private int age;
}
