package com.example.evoter.services.pollService;

import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import org.springframework.stereotype.Service;


public interface PollService {
    VoteResponse castVote(VoteRequest voteRequest) throws OverVotingException, PartyDoesNotExistException;

}
