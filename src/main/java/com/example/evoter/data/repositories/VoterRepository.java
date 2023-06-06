package com.example.evoter.data.repositories;

import com.example.evoter.data.models.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VoterRepository extends MongoRepository<Voter, String> {
    Optional<Voter> findByEmailAddress(String email);
}
