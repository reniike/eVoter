package com.example.evoter.services.voterService;

import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.evoter.utils.AppUtils.ONE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterServiceImplTest {
    @Autowired
    private VoterService voterService;
    @Autowired
    private VoterRepository voterRepository;
    private RegisterVoterRequest voterRequest;

    @Test
    @DisplayName("Register voter test")
    public void testThatVoterCanBeRegistered() throws VoterAlreadyExistException, IllegalAccessException {
        voterRepository.deleteAll();
        voterRequest = new RegisterVoterRequest();
        voterRequest.setFirstName("Aliyah");
        voterRequest.setLastName("Eniola");
        voterRequest.setAge(19);
        voterRequest.setEmailAddress("aliyah@gmail.com");
        voterRequest.setPassword("1234");
        voterService.registerNewVoter(voterRequest);
        assertEquals(ONE, voterRepository.count());
        assertNotNull(voterRepository);
    }

    @Test
    @DisplayName("Null Fields cannot be registered")
    public void testThatNullFieldsCannotBeRegistered() {
        voterRepository.deleteAll();
        voterRequest = new RegisterVoterRequest();
        voterRequest.setFirstName("");
        voterRequest.setLastName("");
        voterRequest.setAge(0);
        voterRequest.setEmailAddress("");
        voterRequest.setPassword("");
        assertThrows(IllegalAccessException.class,() -> voterService.registerNewVoter(voterRequest));
    }

    @Test
    @DisplayName("Invalid email fields cannot register")
    public void testThatInvalidEmailFieldsCannotRegister(){

    }
}