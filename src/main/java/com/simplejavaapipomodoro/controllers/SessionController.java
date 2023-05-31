package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.SessionDTO;
import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
import com.simplejavaapipomodoro.services.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping(value = "/{userId}/session")
    public ResponseEntity<SessionDTO> AddSession(@PathVariable Long userId, @RequestBody @Valid SessionDTO sessionDTO){
        Optional<SessionDTO> responseDTO = sessionService.createSession(userId, sessionDTO.title(), sessionDTO.timeSession().toString());
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "{userId}/all-sessions")
    public ResponseEntity<UserSessionsDTO> getAllSessions(@PathVariable Long userId){
        Optional<UserSessionsDTO> responseDTO = sessionService.allSessions(userId);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
