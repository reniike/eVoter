package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class UnderageVotingException extends EVotingAppException {
    public UnderageVotingException(String message) {
        super(message);
    }
}
