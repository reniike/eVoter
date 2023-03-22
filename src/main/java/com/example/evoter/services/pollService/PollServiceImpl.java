package com.example.evoter.services.pollService;

import com.example.evoter.data.repositories.PollRepo;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.services.partyService.PartyService;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService{
    @Autowired
    PollRepo pollRepo;
    @Autowired
    PartyService partyService;

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) throws OverVotingException, PartyDoesNotExistException {
        validateOverVoting(voteRequest.getVoterId());
        validatePartyExistence(voteRequest.getPartyName());
        return Mapper.map(pollRepo.save(Mapper.map(voteRequest)));
    }

    private void validatePartyExistence(String partyName) throws PartyDoesNotExistException {
        partyService.findByName(partyName);
    }

    private void validateOverVoting(String voterId) throws OverVotingException {
        if (pollRepo.findByVoterId(voterId) != null) throw new OverVotingException("User has already voted");
    }
}
