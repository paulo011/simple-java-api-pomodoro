package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.SessionDTO;
import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.SessionRepository;
import com.simplejavaapipomodoro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;

    public void create(Long id, SessionDTO sessionDTO){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            sessionRepository.save(new Session(user.get(), sessionDTO.title(), sessionDTO.timeSession()));
        }
    }
}
