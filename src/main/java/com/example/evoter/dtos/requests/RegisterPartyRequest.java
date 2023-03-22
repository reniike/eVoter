package com.example.evoter.dtos.requests;

import lombok.Data;

@Data
public class RegisterPartyRequest {
    private String name;
    private String candidate;
}
