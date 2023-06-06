package com.example.evoter.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoterLogInRequest {
    private String emailAddress;
    private String password;
}
