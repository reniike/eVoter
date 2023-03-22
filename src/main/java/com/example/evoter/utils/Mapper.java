package com.example.evoter.utils;

import com.example.evoter.data.models.Party;
import com.example.evoter.data.models.Poll;
import com.example.evoter.data.models.User;
import com.example.evoter.dtos.requests.RegisterPartyRequest;
import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.RegisterPartyResponse;
import com.example.evoter.dtos.responses.RegisterUserResponse;
import com.example.evoter.dtos.responses.VoteResponse;

public class Mapper {
    public static User map(RegisterUserRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        user.setEmailAddress(request.getEmailAddress());
        user.setPassword(request.getPassword());
        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse response = new RegisterUserResponse();
        response.setName(user.getFirstName() + " " + user.getLastName());
        response.setEmailAddress(user.getEmailAddress());
        response.setUserId(user.getId());
        response.setAge(user.getAge());
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
