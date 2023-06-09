package com.example.evoter.services.pollService;

import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;

import java.util.TreeMap;

public interface PollService {
    VoteResponse castVote(VoteRequest voteRequest);
    long countAllVote(String partyName);

    TreeMap<String, Long> getResult();
}
