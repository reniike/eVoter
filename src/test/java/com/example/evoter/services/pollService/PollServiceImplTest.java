package com.example.evoter.services.pollService;


import com.example.evoter.data.repositories.PollRepo;
import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoteRequest;
import com.example.evoter.dtos.responses.RegisterVoterResponse;
import com.example.evoter.dtos.responses.VoteResponse;
import com.example.evoter.services.voterService.VoterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    class PollServiceImplTest {
        @Autowired
        PollService pollService;
        @Autowired
        PollRepo pollRepo;
        @Autowired
        VoterService voterService;
        @Autowired
        VoterRepository voterRepository;
        VoteRequest voteRequest;
        RegisterVoterRequest voterRequest = new RegisterVoterRequest();


        @Test
        @DisplayName("Cast Vote test")
        void castVoteTest() {
            voterRepository.deleteAll();
            voterRequest.setFirstName("Aliyah");
            voterRequest.setLastName("Eniola");
            voterRequest.setAge(19);
            voterRequest.setEmailAddress("aliyah@gmail.com");
            voterRequest.setPassword("1234");
            RegisterVoterResponse registerVoterResponse =  voterService.registerNewVoter(voterRequest);

            voteRequest = new VoteRequest();
            voteRequest.setVoterId(registerVoterResponse.getVoterId());
            voteRequest.setPartyName("APC");
            VoteResponse voteResponse = pollService.castVote(voteRequest);
            assertNotNull(voteResponse.getMessage());
            assertNotNull(voteResponse.getVoterId());
        }
}
