package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class RequestHasNullFieldException extends EVotingAppException {
    public RequestHasNullFieldException(String message) {
        super(message);
    }
}
