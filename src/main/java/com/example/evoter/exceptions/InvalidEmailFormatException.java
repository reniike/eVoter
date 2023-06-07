package com.example.evoter.exceptions;

import com.example.evoter.utils.eVotingAppException;

public class InvalidEmailFormatException extends eVotingAppException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
