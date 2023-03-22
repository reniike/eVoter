package com.example.evoter.data.repositories;

import com.example.evoter.data.models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PartyRepository extends MongoRepository<Party, String> {
    Optional<Party> findByName(String name);
}
