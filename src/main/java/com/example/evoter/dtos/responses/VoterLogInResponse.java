package com.example.evoter.dtos.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoterLogInResponse {
    private String id;
    private String message;
}
