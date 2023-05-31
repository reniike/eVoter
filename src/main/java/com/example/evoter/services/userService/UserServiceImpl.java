package com.example.evoter.services.userService;


import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.responses.RegisterUserResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private VoterRepository voterRepository;
    @Override
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) throws VoterAlreadyExistException {
        validateDuplicateVoter(request.getEmailAddress());
        Voter voter = Mapper.map(request);
        Voter returnedVoter = voterRepository.save(voter);
        RegisterUserResponse response = Mapper.map(returnedVoter);
        return response;
    }

    private void validateDuplicateVoter(String emailAddress) throws VoterAlreadyExistException {
        if (voterRepository.findByEmailAddress(emailAddress).isPresent())
            throw new VoterAlreadyExistException("Voter with "+emailAddress+" has been registered");
    }
}
