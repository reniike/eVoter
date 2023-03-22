package com.example.evoter.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class VoteResponse {
    @Id
    private String voterId;
    private String PartyName;
}
