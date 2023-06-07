package com.example.evoter.exceptions;

import com.example.evoter.utils.eVotingAppException;

public class IncorrectEmailFormatException extends eVotingAppException {
    public IncorrectEmailFormatException(String message) {
        super(message);
    }
}
