package com.example.evoter.exceptions;

public class WrongPasswordException extends eVotingAppException{
    public WrongPasswordException(String message) {
        super(message);
    }
}
