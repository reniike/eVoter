package com.example.evoter.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterVoterResponse {
    private String voterId;
    private String name;
    private String emailAddress;
    private int age;
}
