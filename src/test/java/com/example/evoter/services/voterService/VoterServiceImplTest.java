package com.example.evoter.services.voterService;

import com.example.evoter.data.repositories.VoterRepository;
import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.dtos.requests.VoterLogInRequest;
import com.example.evoter.dtos.responses.VoterLogInResponse;
import com.example.evoter.exceptions.InvalidEmailFormatException;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.exceptions.VoterNotRegisteredException;
import com.example.evoter.exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.evoter.utils.AppUtils.ONE;
import static com.example.evoter.utils.AppUtils.VOTER_SUCCESSFULLY_LOGGED_IN;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoterServiceImplTest {
    @Autowired
    private VoterService voterService;
    @Autowired
    private VoterRepository voterRepository;
    private RegisterVoterRequest voterRequest;
    @BeforeEach
    public void setUp() throws VoterAlreadyExistException, IllegalAccessException, InvalidEmailFormatException {
        voterRepository.deleteAll();
        voterRequest = new RegisterVoterRequest();
        voterRequest.setFirstName("Aliyah");
        voterRequest.setLastName("Eniola");
        voterRequest.setAge(19);
        voterRequest.setEmailAddress("aliyah@gmail.com");
        voterRequest.setPassword("1234");
        voterService.registerNewVoter(voterRequest);
    }

    @Test
    @DisplayName("Register voter test")
    public void testThatVoterCanBeRegistered(){
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
    @DisplayName("Login Test")
    public void testThatUserCanLogIn() throws VoterNotRegisteredException, WrongPasswordException {
        VoterLogInRequest voterLogInRequest = new VoterLogInRequest();
        voterLogInRequest.setEmailAddress("aliyah@gmail.com");
        voterLogInRequest.setPassword("1234");
        VoterLogInResponse voterLogInResponse = voterService.logIn(voterLogInRequest);
        assertEquals(String.format(VOTER_SUCCESSFULLY_LOGGED_IN), voterLogInResponse.getMessage());
        assertNotNull(voterLogInResponse.getId());
    }

    @Test
    @DisplayName("Unregistered voter can't log in")
    public void unregisteredVoterCan_tLogInTest() {
        VoterLogInRequest voterLogInRequest = new VoterLogInRequest();
        voterLogInRequest.setEmailAddress("eniola@gmail.com");
        voterLogInRequest.setPassword("1234");
        assertThrows(VoterNotRegisteredException.class, () -> voterService.logIn(voterLogInRequest));
    }
    @Test
    @DisplayName("Wrong password throws an exception")
    public void userWithWrongPasswordCan_tLoginTest(){
        VoterLogInRequest voterLogInRequest = new VoterLogInRequest();
        voterLogInRequest.setEmailAddress("aliyah@gmail.com");
        voterLogInRequest.setPassword("1235");
        assertThrows(WrongPasswordException.class, () -> voterService.logIn(voterLogInRequest));
    }
    @Test
    @DisplayName("Invalid email format throws an exception")
    public void testThatInvalidEmailFormatThrowsAnException() {
        voterRequest = new RegisterVoterRequest();
        voterRequest.setFirstName("Aliyah");
        voterRequest.setLastName("Eniola");
        voterRequest.setAge(19);
        voterRequest.setEmailAddress("aliyahgmail.com");
        voterRequest.setPassword("1234");
        assertThrows(InvalidEmailFormatException.class, () -> voterService.registerNewVoter(voterRequest));
    }


}