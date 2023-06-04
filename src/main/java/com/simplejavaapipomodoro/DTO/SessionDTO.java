package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.Session;
import com.simplejavaapipomodoro.entities.TimeSession;
import jakarta.validation.constraints.NotBlank;

public record SessionDTO(@NotBlank String title, @NotBlank TimeSession timeSession) {
    public SessionDTO(Session session){
        this(session.getTitle(), new TimeSession(session.getTimeSession()));
    }
}
