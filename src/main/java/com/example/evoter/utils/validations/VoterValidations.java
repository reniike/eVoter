package com.example.evoter.utils.validations;

import com.example.evoter.data.models.Voter;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.exceptions.*;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.regex.Pattern;

import static com.example.evoter.utils.AppUtils.*;
import static com.example.evoter.utils.AppUtils.MINIMUM_VOTER_AGE_IS_EIGHTEEN;

@AllArgsConstructor
public class VoterValidations {
    public static void validateRegisteredVoter(Optional<Voter> voter) {
        if (voter.isEmpty())
            throw new VoterNotRegisteredException("Voter not registered!");
    }

    public static void validateDuplicateVoter(String emailAddress, VoterRepository voterRepository) {
        if (voterRepository.findByEmailAddress(emailAddress).isPresent()){
            throw new VoterAlreadyExistException(String.format(VOTER_WITH_EMAIL_EXISTS, emailAddress));
        }
    }

    public static void validateEmailFormat(String emailAddress) {
        if (!Pattern.matches(EMAIL_PATTERN, emailAddress))
            throw new InvalidEmailFormatException("Invalid email format");
    }

    public static void validateVoterAge(int age) {
        if (age < EIGTHEEN) throw new UnderageVotingException(MINIMUM_VOTER_AGE_IS_EIGHTEEN);
    }

    public static  void validateRequestFields(RegisterVoterRequest registerVoterRequest) {
        if (registerVoterRequest.getEmailAddress() == null ||
                registerVoterRequest.getEmailAddress().isBlank() ||
                registerVoterRequest.getPassword() == null ||
                registerVoterRequest.getPassword().isBlank() ||
                registerVoterRequest.getAge() == 0 ||
                registerVoterRequest.getFirstName() == null ||
                registerVoterRequest.getFirstName().isBlank() ||
                registerVoterRequest.getLastName() == null ||
                registerVoterRequest.getLastName().isBlank())
            throw new RequestHasNullFieldException("All Fields are required");
    }
}
