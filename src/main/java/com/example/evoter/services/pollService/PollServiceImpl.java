package com.example.evoter.services.pollService;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.repositories.PartyRepository;
import com.example.evoter.data.repositories.PollRepo;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

import static com.example.evoter.utils.validations.PartyValidations.validatePartyExistence;
import static com.example.evoter.utils.validations.PollValidations.validateOverVoting;

@Service
@AllArgsConstructor
public class PollServiceImpl implements PollService{
    private final PollRepo pollRepo;
    private final PartyRepository partyRepository;

    @Override
    public VoteResponse castVote(VoteRequest voteRequest){
        validateOverVoting(voteRequest.getVoterId(), pollRepo);
        validatePartyExistence(voteRequest.getPartyName(), partyRepository);
        return Mapper.map(pollRepo.save(Mapper.map(voteRequest)));
    }
    @Override
    public long countAllVote(String partyName) {
       return pollRepo.countPollsByPartyName(partyName);
    }

    @Override
    public TreeMap<String, Long> getResult() {
        TreeMap<String, Long> map = new TreeMap<>();
        for (Party party: partyRepository.findAll()) {
            map.put(party.getName(), pollRepo.countPollsByPartyName(party.getName()));
        }
        return map;
    }
}
