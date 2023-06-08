package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class PartyDoesNotExistException extends EVotingAppException {
    public PartyDoesNotExistException(String message) {
        super(message);
    }
}
