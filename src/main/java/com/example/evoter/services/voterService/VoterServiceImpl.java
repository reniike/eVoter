package com.example.evoter.services.voterService;


import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoterLogInResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.evoter.utils.AppUtils.*;
import static com.example.evoter.utils.validations.VoterValidations.*;

@Service
@AllArgsConstructor
@Slf4j
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;
    private final ModelMapper modelMapper;

    @Override
    public RegisterVoterResponse registerNewVoter(RegisterVoterRequest registerVoterRequest) {
        validateRequestFields(registerVoterRequest);
        validateVoterAge(registerVoterRequest.getAge());
        validateEmailFormat(registerVoterRequest.getEmailAddress());
        validateDuplicateVoter(registerVoterRequest.getEmailAddress(), voterRepository);
        Voter voter = modelMapper.map(registerVoterRequest, Voter.class);
        hashPassword(registerVoterRequest.getPassword());
        voterRepository.save(voter);
        RegisterVoterResponse registerVoterResponse = buildVoterResponse(voter);
        log.info(String.format(VOTER_REGISTERED_SUCCESSFULLY, registerVoterResponse.getEmailAddress()));
        return registerVoterResponse;
    }

    @Override
    public VoterLogInResponse logIn(VoterLogInRequest voterLogInRequest) {
        Optional<Voter> foundVoter = voterRepository.findByEmailAddress(voterLogInRequest.getEmailAddress());
        validateRegisteredVoter(foundVoter);
        Voter voter = foundVoter.get();
        checkPassword(voterLogInRequest.getPassword(), voter.getPassword());
        log.info(String.format(VOTER_SUCCESSFULLY_LOGGED_IN));
        return VoterLogInResponse.builder()
                .id(voter.getId())
                .message(String.format(VOTER_SUCCESSFULLY_LOGGED_IN))
                .build();
    }

    private static RegisterVoterResponse buildVoterResponse(Voter voter) {
        return RegisterVoterResponse.builder()
                .name(voter.getFirstName() + " " + voter.getLastName())
                .voterId(voter.getId())
                .emailAddress(voter.getEmailAddress())
                .build();
    }
    @Override
    public long countAllVoters() {
        return voterRepository.count();
    }

}
