package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class InvalidEmailFormatException extends EVotingAppException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
