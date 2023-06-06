package com.example.evoter.controllers;

import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.exceptions.OverVotingException;
import com.example.evoter.exceptions.PartyDoesNotExistException;
import com.example.evoter.services.pollService.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping("/poll/{partyName}")
    public Object countVoteByPartyName(@PathVariable String partyName){
        try {
            return pollService.countAllVote(partyName);
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @GetMapping("/calculateResult")
    public ResponseEntity<Map<String, Long>> calculateResult(){
        Map<String, Long> result = pollService.getResult();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
