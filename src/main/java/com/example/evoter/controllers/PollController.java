package com.example.evoter.controllers;

import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.services.pollService.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {
    @Autowired
    private PollService pollService;

    @PostMapping("/poll/castVote")
    public Object poll(@RequestBody VoteRequest voteRequest){
        try {
            return pollService.castVote(voteRequest);
        }catch (OverVotingException | PartyDoesNotExistException e) {
            return e.getMessage();
        }
    }

}
