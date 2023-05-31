package com.example.evoter.controllers;

import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyAlreadyExistException;
import com.example.evoter.services.partyService.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {

    @Autowired
    private PartyService partyService;

    @PostMapping("/party/register")
    public ResponseEntity<?> register(@RequestBody RegisterPartyRequest registerPartyRequest){
        try{
            RegisterPartyResponse response = partyService.registerNewParty(registerPartyRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (PartyAlreadyExistException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
