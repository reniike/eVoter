package com.example.evoter.data.repositories;

import com.example.evoter.data.models.Poll;
import com.example.evoter.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PollRepo extends MongoRepository<Poll, String> {

    User findByVoterId(String voterId);

}
