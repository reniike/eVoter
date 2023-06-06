package com.example.evoter.services.partyService;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.repositories.PartyRepository;
import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.exceptions.PartyAlreadyExistException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartyServiceImpl implements PartyService{

    @Autowired
    private PartyRepository partyRepository;


    @Override
    public RegisterPartyResponse registerNewParty(RegisterPartyRequest request) throws PartyAlreadyExistException {
        validatePartyExistence(request.getName());
        return Mapper.map(partyRepository.save(Mapper.map(request)));
    }

    private void validatePartyExistence(String name) throws PartyAlreadyExistException {
        if (partyRepository.findByName(name).isPresent())
            throw new PartyAlreadyExistException("Party with "+ name +" already exist.");
    }

    public RegisterPartyResponse findByName(String name) throws PartyDoesNotExistException {
        Optional<Party> party = partyRepository.findByName(name);
        if (party.isEmpty()) throw new PartyDoesNotExistException("Party specified does not exist");
        return Mapper.map(party.get());
    }
}
