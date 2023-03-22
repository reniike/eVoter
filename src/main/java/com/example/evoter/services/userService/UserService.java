package com.example.evoter.services.userService;

import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.dtos.responses.RegisterUserResponse;
import com.example.evoter.exceptions.VoterAlreadyExistException;


public interface UserService {
    RegisterUserResponse registerNewUser(RegisterUserRequest request)throws VoterAlreadyExistException ;
}
