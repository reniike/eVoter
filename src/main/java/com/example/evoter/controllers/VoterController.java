package com.example.evoter.controllers;

import com.example.evoter.dtos.requests.RegisterVoterRequest;
import com.example.evoter.exceptions.InvalidEmailFormatException;
import com.example.evoter.exceptions.VoterAlreadyExistException;
import com.example.evoter.services.voterService.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/user/register")
    public Object register(@RequestBody RegisterVoterRequest request){
        try{
            return voterService.registerNewVoter(request);
        }catch (VoterAlreadyExistException e){
            return e.getMessage();
        } catch (IllegalAccessException | InvalidEmailFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
