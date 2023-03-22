package com.example.evoter.services.partyService;

import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.dtos.responses.RegisterUserResponse;
import com.example.evoter.exceptions.PartyAlreadyExistException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.exceptions.VoterAlreadyExistException;

public interface PartyService {
    RegisterPartyResponse registerNewParty(RegisterPartyRequest request) throws PartyAlreadyExistException;
    RegisterPartyResponse findByName(String name) throws PartyDoesNotExistException;
}
