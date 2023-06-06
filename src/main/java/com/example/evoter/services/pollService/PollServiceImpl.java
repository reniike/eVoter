package com.example.evoter.services.pollService;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.models.Poll;
import com.example.evoter.data.repositories.PartyRepository;
import com.example.evoter.data.repositories.PollRepo;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.services.partyService.PartyService;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
public class PollServiceImpl implements PollService{
    @Autowired
    PollRepo pollRepo;
    @Autowired
    PartyRepository partyRepository;
    @Autowired
    PartyService partyService;

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) throws OverVotingException, PartyDoesNotExistException {
        validateOverVoting(voteRequest.getVoterId());
        validatePartyExistence(voteRequest.getPartyName());
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
    private void validatePartyExistence(String partyName) throws PartyDoesNotExistException {
        partyService.findByName(partyName);
    }

    private void validateOverVoting(String voterId) throws OverVotingException {
        if (pollRepo.findByVoterId(voterId) != null) throw new OverVotingException("Voter has already voted");
    }
}
