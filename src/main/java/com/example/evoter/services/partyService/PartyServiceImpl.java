package com.example.evoter.services.partyService;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.repositories.PartyRepository;
import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.evoter.utils.validations.PartyValidations.validatePartyExistence;

@Service
@AllArgsConstructor
public class PartyServiceImpl implements PartyService{
    private PartyRepository partyRepository;
    @Override
    public RegisterPartyResponse registerNewParty(RegisterPartyRequest request){
        validatePartyExistence(request.getName(), partyRepository);
        return Mapper.map(partyRepository.save(Mapper.map(request)));
    }

    public RegisterPartyResponse findByName(String name) {
        Optional<Party> party = partyRepository.findByName(name);
        if (party.isEmpty()) throw new PartyDoesNotExistException("Party specified does not exist");
        return Mapper.map(party.get());
    }
}
