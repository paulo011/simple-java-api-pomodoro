package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.SessionDTO;
import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
import com.simplejavaapipomodoro.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/{userId}/session")
    public void AddSession(@PathVariable Long userId, @RequestBody SessionDTO sessionDTO){
        System.out.println(sessionDTO.timeSession());
        sessionService.create(userId,  sessionDTO.title(), sessionDTO.timeSession().toString());
    }

    @GetMapping(value = "{userId}/all-sessions")
    public ResponseEntity<UserSessionsDTO> getSessions(@PathVariable Integer userId){
        return ResponseEntity.ok(sessionService.allSessions(userId));
    }
}
