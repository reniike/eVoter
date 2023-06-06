package com.example.evoter.services.voterService;

import com.example.evoter.data.models.Voter;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoterLogInResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.exceptions.VoterNotRegisteredException;
import com.example.evoter.exceptions.WrongPasswordException;


public interface VoterService {
    RegisterVoterResponse registerNewVoter(RegisterVoterRequest registerVoterRequest)throws VoterAlreadyExistException ;

    long countAllVoters();

}
