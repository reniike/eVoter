package com.example.evoter.services.voterService;


import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;

import static com.example.evoter.utils.AppUtils.*;

@Service
@AllArgsConstructor
@Slf4j
public class VoterServiceImpl implements VoterService {
    @Autowired
    private final VoterRepository voterRepository;
    private final ModelMapper modelMapper;

    //You are doing very well. I'm proud!
    @Override
    public RegisterVoterResponse registerNewVoter(RegisterVoterRequest registerVoterRequest) throws VoterAlreadyExistException, IllegalAccessException {
        if (requestHasNullFields(registerVoterRequest)) throw new IllegalAccessException();
        validateDuplicateVoter(registerVoterRequest.getEmailAddress());
        Voter voter = modelMapper.map(registerVoterRequest, Voter.class);
        hashPassword(registerVoterRequest.getPassword());
        voterRepository.save(voter);
        RegisterVoterResponse registerVoterResponse = buildVoterResponse(voter);
        log.info(String.format(VOTER_REGISTERED_SUCCESSFULLY, registerVoterResponse.getEmailAddress()));
        return registerVoterResponse;
    }

    private boolean requestHasNullFields(RegisterVoterRequest registerVoterRequest) {
        return registerVoterRequest.getEmailAddress() == null ||
                registerVoterRequest.getEmailAddress().isBlank() ||
                registerVoterRequest.getPassword() == null ||
                registerVoterRequest.getPassword().isBlank() ||
                registerVoterRequest.getAge() == 0 ||
                registerVoterRequest.getFirstName() == null ||
                registerVoterRequest.getFirstName().isBlank() ||
                registerVoterRequest.getLastName() == null ||
                registerVoterRequest.getFirstName().isBlank();
    }


    private static RegisterVoterResponse buildVoterResponse(Voter voter) {
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
