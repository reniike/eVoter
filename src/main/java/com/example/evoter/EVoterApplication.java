package com.example.evoter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class EVoterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EVoterApplication.class, args);
    }

}
