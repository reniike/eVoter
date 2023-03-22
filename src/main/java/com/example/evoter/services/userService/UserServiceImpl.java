package com.example.evoter.services.userService;


import com.example.evoter.data.models.User;
import com.example.evoter.data.repositories.UserRepository;
import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.responses.RegisterUserResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) throws VoterAlreadyExistException {
        validateDuplicateVoter(request.getEmailAddress());
        User user = Mapper.map(request);
        User returnedUser = userRepository.save(user);
        RegisterUserResponse response = Mapper.map(returnedUser);
        return response;
    }

    private void validateDuplicateVoter(String emailAddress) throws VoterAlreadyExistException {
        if (userRepository.findByEmailAddress(emailAddress).isPresent())
            throw new VoterAlreadyExistException("Voter with "+emailAddress+" has been registered");
    }


}
