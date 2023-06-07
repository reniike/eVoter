package com.example.evoter.exceptions;

import com.example.evoter.utils.eVotingAppException;

public class VoterNotRegisteredException extends eVotingAppException {
    public VoterNotRegisteredException(String message) {
        super(message);
    }
}
