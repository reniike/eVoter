package com.example.evoter.controllers;

import com.example.evoter.data.models.Voter;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.exceptions.InvalidEmailFormatException;
import com.example.evoter.exceptions.RequestHasNullFieldException;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.services.voterService.VoterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class VoterController {
    private final VoterService voterService;

    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody RegisterVoterRequest request) {
        RegisterVoterResponse response = voterService.registerNewVoter(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
