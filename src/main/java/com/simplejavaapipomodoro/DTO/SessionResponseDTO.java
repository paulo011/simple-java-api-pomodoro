package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.TimeSession;

public record SessionResponseDTO(String title, TimeSession timeSession) {
    public SessionResponseDTO(Session session){
        this(session.getTitle(), new TimeSession(session.getTimeSession()));
    }
}
