package com.example.evoter.data.repositories;

import com.example.evoter.data.models.Poll;
import com.example.evoter.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepo extends MongoRepository<Poll, String> {

    Voter findByVoterId(String voterId);

    List<Poll> findPollsByPartyName(String partyName);

    long countPollsByPartyName(String partyName);

}
