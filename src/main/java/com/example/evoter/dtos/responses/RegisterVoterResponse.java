package com.example.evoter.dtos.responses;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RegisterVoterResponse {
    private String voterId;
    private String name;
    private String emailAddress;
}
