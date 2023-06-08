package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class VoterNotRegisteredException extends EVotingAppException {
    public VoterNotRegisteredException(String message) {
        super(message);
    }
}
