package com.example.evoter.utils.validations;

import com.example.evoter.data.repositories.PartyRepository;
import com.example.evoter.exceptions.PartyAlreadyExistException;

public class PartyValidations {
    public static void validatePartyExistence(String name, PartyRepository partyRepository) {
        if (partyRepository.findByName(name).isPresent())
            throw new PartyAlreadyExistException("Party with "+ name +" already exist.");
    }
}
