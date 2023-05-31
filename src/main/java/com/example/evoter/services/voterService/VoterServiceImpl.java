package com.example.evoter.services.voterService;


import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    private VoterRepository voterRepository;
    @Override
    public RegisterVoterResponse registerNewVoter(RegisterVoterRequest request) throws VoterAlreadyExistException {
        validateDuplicateVoter(request.getEmailAddress());
        Voter voter = Mapper.map(request);
        Voter returnedVoter = voterRepository.save(voter);
        RegisterVoterResponse response = Mapper.map(returnedVoter);
        return response;
    }

    private void validateDuplicateVoter(String emailAddress) throws VoterAlreadyExistException {
        if (voterRepository.findByEmailAddress(emailAddress).isPresent())
            throw new VoterAlreadyExistException("Voter with "+emailAddress+" has been registered");
    }
}
