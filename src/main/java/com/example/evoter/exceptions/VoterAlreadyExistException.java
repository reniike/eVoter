package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class VoterAlreadyExistException extends EVotingAppException {
    public VoterAlreadyExistException(String message) {
        super(message);
    }
}
