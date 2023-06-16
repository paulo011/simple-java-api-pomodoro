package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.ErrorDTO;
import com.simplejavaapipomodoro.DTO.SessionResponseDTO;
import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
import com.simplejavaapipomodoro.entities.TimeSession;
import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.SessionRepository;
import com.simplejavaapipomodoro.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> addSession(Long id, String title, String timeSession){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(HttpStatus.NOT_FOUND, "id not found"));

        Optional<Session> sessionOptional = sessionRepository.findByTitle(title);
        if(sessionOptional.isPresent()){
            TimeSession firstTimeSession = new TimeSession(timeSession);
            TimeSession secondTimeSession = new TimeSession(sessionOptional.get().getTimeSession());
            sessionOptional.get().setTimeSession(firstTimeSession.concatenateTime(secondTimeSession));
            return ResponseEntity.ok(new SessionResponseDTO(sessionOptional.get()));
        }

        Session session = sessionRepository.save(new Session(user.get(), title, timeSession));
        return ResponseEntity.ok(new SessionResponseDTO(session));
    }

    public ResponseEntity<?> findAllSessions(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO(HttpStatus.NOT_FOUND, "id not found"));
        }

        Optional<List<Session>> optionalSessions = sessionRepository.findAllByUserId(optionalUser.get().getId());
        List<SessionResponseDTO> sessionDTOS = new ArrayList<>();
        TimeSession totalTimeSession = new TimeSession();

        if(optionalSessions.isPresent()){
            optionalSessions.get().forEach(value -> {
                SessionResponseDTO sessionDTO = new SessionResponseDTO(
                        value.getTitle(), new TimeSession(value.getTimeSession()));
                sessionDTOS.add(sessionDTO);
            });

            sessionDTOS.forEach(value -> {
                TimeSession timeSession = new TimeSession(value.timeSession().toString());
                totalTimeSession.concatenateTime(timeSession);
            });
        }

        return ResponseEntity.ok(new UserSessionsDTO(totalTimeSession, sessionDTOS));
    }
}
