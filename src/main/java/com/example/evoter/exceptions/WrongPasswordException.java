package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class WrongPasswordException extends EVotingAppException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
