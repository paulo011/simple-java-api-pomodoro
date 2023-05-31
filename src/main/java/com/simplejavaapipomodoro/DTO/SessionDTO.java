package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.TimeSession;

public record SessionDTO(String title, TimeSession timeSession) {
    public SessionDTO(Session session){
        this(session.getTitle(), new TimeSession(session.getTimeSession()));
    }
}
