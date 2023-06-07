package com.example.evoter.exceptions;

import com.example.evoter.utils.eVotingAppException;

public class WrongPasswordException extends eVotingAppException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
