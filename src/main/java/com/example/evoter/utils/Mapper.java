package com.example.evoter.utils;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.models.Poll;
import com.example.evoter.data.models.Voter;
import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoteResponse;

public class Mapper {
    public static Voter map(RegisterVoterRequest request){
        Voter voter = new Voter();
        voter.setFirstName(request.getFirstName());
        voter.setLastName(request.getLastName());
        voter.setAge(request.getAge());
        voter.setEmailAddress(request.getEmailAddress());
        voter.setPassword(request.getPassword());
        return voter;
    }

    public static RegisterVoterResponse map(Voter voter) {
        RegisterVoterResponse response = new RegisterVoterResponse();
        response.setName(voter.getFirstName() + " " + voter.getLastName());
        response.setEmailAddress(voter.getEmailAddress());
        response.setVoterId(voter.getId());
        response.setAge(voter.getAge());
        return response;
    }
    public static VoteResponse map(Poll poll){
        VoteResponse voteResponse = new VoteResponse();
        voteResponse.setPartyName(poll.getPartyName());
        voteResponse.setVoterId(poll.getVoterId());
        return voteResponse;
    }

    public static Poll map(VoteRequest voteRequest) {
        Poll poll = new Poll();
        poll.setPartyName(voteRequest.getPartyName());
        poll.setVoterId(voteRequest.getVoterId());
        return poll;
    }

    public static Party map(RegisterPartyRequest request) {
        Party party = new Party();
        party.setName(request.getName());
        party.setCandidate(request.getCandidate());
        return party;
    }

    public static RegisterPartyResponse map(Party party) {
        RegisterPartyResponse response = new RegisterPartyResponse();
        response.setId(party.getId());
        response.setName(party.getName());
        response.setCandidate(party.getCandidate());
        return response;
    }
}
