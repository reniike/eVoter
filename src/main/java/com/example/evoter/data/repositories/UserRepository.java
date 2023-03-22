package com.example.evoter.data.repositories;

import com.example.evoter.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAddress(String email);
}
