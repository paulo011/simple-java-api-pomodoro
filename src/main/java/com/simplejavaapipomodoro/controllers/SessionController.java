package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.SessionDTO;
import com.simplejavaapipomodoro.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/{userId}/session")
    public void AddSession(@PathVariable Long userId, @RequestBody SessionDTO sessionDTO){
        sessionService.create(userId, sessionDTO);
    }
}
