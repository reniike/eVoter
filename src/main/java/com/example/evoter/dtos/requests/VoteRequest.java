package com.example.evoter.dtos.requests;

import lombok.Data;

@Data
public class VoteRequest {
    private String voterId;
    private String partyName;
}
