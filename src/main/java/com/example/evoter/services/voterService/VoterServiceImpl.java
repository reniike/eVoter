package com.example.evoter.services.voterService;


import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoterLogInResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.exceptions.VoterNotRegisteredException;
import com.example.evoter.exceptions.WrongPasswordException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.evoter.utils.AppUtils.*;

@Service
@AllArgsConstructor
@Slf4j
public class VoterServiceImpl implements VoterService {
    @Autowired
    private final VoterRepository voterRepository;
    private final ModelMapper modelMapper;


    @Override
    public RegisterVoterResponse registerNewVoter(RegisterVoterRequest registerVoterRequest) throws VoterAlreadyExistException {
        validateDuplicateVoter(registerVoterRequest.getEmailAddress());
        Voter voter = modelMapper.map(registerVoterRequest, Voter.class);
        hashPassword(registerVoterRequest.getPassword());
        voterRepository.save(voter);
        RegisterVoterResponse registerVoterResponse = buildVoterResponse(voter);
        log.info(String.format(VOTER_REGISTERED_SUCCESSFULLY, registerVoterResponse.getEmailAddress()));
        return registerVoterResponse;
    }


    private static RegisterVoterResponse buildVoterResponse(Voter voter){
        return RegisterVoterResponse.builder()
                .name(voter.getFirstName() + " " + voter.getLastName())
                .voterId(voter.getId())
                .emailAddress(voter.getEmailAddress())
                .build();
    }

        private void validateDuplicateVoter(String emailAddress) throws VoterAlreadyExistException {
        if (voterRepository.findByEmailAddress(emailAddress).isPresent())
            throw new VoterAlreadyExistException(String.format(VOTER_WITH_EMAIL_EXISTS, emailAddress));
    }
    @Override
    public long countAllVoters() {
       return voterRepository.count();
    }


}
