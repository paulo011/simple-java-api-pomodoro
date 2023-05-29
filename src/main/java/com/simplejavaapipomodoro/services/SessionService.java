package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.SessionDTO;
import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
import com.simplejavaapipomodoro.entities.TimeSession;
import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.SessionRepository;
import com.simplejavaapipomodoro.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void create(Long id, String title, String timeSession){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            sessionRepository.save(new Session(user.get(), title, timeSession));
        }
    }

    public UserSessionsDTO allSessions(Integer id){
        Optional<List<Session>> optionalSessions = sessionRepository.findAllByUserId(id);

        List<SessionDTO> sessionDTOS = new ArrayList<>();
        TimeSession totalTimeSession = new TimeSession();

        if(optionalSessions.isPresent()){
            optionalSessions.get().forEach(
                    value -> {
                        SessionDTO sessionDTO = new SessionDTO(value.getTitle(), new TimeSession(value.getTimeSession()));
                        sessionDTOS.add(sessionDTO);
                    }
            );
            sessionDTOS.forEach(value -> {
                TimeSession timeSession = new TimeSession(value.timeSession().toString());
                totalTimeSession.concatenateTime(timeSession);
            });
        }
        return new UserSessionsDTO(totalTimeSession, sessionDTOS);
    }
}
