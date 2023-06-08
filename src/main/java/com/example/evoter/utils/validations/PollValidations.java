package com.example.evoter.utils.validations;

import com.example.evoter.data.repositories.PollRepo;
import com.example.evoter.exceptions.OverVotingException;

public class PollValidations {
    public static void  validateOverVoting(String voterId, PollRepo pollRepo){
        if (pollRepo.findByVoterId(voterId) != null) throw new OverVotingException("Voter has already voted");
    }
}
