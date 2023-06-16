package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.ErrorDTO;
import com.simplejavaapipomodoro.DTO.SessionRequestDTO;
import com.simplejavaapipomodoro.DTO.SessionResponseDTO;
import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
import com.simplejavaapipomodoro.services.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/{userId}/session")
    public ResponseEntity<?> AddSession(@PathVariable Long userId, @RequestBody @Valid SessionRequestDTO sessionDTO){
        return  sessionService.addSession(
                userId, sessionDTO.title(), sessionDTO.timeSession());
    }

    @GetMapping(value = "{userId}/all-sessions")
    public ResponseEntity<?> getAllSessions(@PathVariable Long userId){
        return sessionService.findAllSessions(userId);
    }
}
