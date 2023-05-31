package com.example.evoter.services.voterService;

import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;


public interface VoterService {
    RegisterVoterResponse registerNewVoter(RegisterVoterRequest request)throws VoterAlreadyExistException ;
}
