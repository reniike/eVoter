package com.example.evoter.dtos.responses;

import lombok.Data;

@Data
public class RegisterPartyResponse {
    private String id;
    private String name;
    private String candidate;
}
