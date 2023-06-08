package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class OverVotingException extends EVotingAppException {
    public OverVotingException(String message) {
        super(message);
    }
}
