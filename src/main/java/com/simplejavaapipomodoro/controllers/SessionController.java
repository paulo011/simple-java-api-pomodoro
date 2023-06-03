package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.ErrorDTO;
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
    public ResponseEntity<?> AddSession(@PathVariable Long userId, @RequestBody @Valid SessionDTO sessionDTO){
        Optional<SessionDTO> responseDTO = sessionService.createSession(
                userId, sessionDTO.title(), sessionDTO.timeSession().toString());
        if(responseDTO.isEmpty()){
            return ResponseEntity.badRequest().body(new ErrorDTO(400, "title or timeSession invalid"));
        }
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "{userId}/all-sessions")
    public ResponseEntity<UserSessionsDTO> getAllSessions(@PathVariable Long userId){
        Optional<UserSessionsDTO> responseDTO = sessionService.allSessions(userId);
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
