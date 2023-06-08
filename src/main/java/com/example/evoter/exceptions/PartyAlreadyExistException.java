package com.example.evoter.exceptions;

import com.example.evoter.utils.EVotingAppException;

public class PartyAlreadyExistException extends EVotingAppException {

    public PartyAlreadyExistException(String message){
        super(message);
    }
}
