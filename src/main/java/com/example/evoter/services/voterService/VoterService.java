package com.example.evoter.services.voterService;

import com.example.evoter.data.models.Voter;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoterLogInResponse;
import com.example.evoter.exceptions.*;


public interface VoterService {
    RegisterVoterResponse registerNewVoter(RegisterVoterRequest registerVoterRequest);

    long countAllVoters();
    VoterLogInResponse logIn(VoterLogInRequest voterLogInRequest);

}
