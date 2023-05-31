package com.example.evoter.controllers;

import com.example.evoter.dtos.requests.RegisterUserRequest;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Object register(@RequestBody RegisterUserRequest request){
        try{
            return userService.registerNewUser(request);
        }catch (VoterAlreadyExistException e){
            return e.getMessage();
        }
    }

}
