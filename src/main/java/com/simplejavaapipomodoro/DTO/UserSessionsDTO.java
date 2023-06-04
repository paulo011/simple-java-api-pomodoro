package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.TimeSession;

import java.util.List;

public record UserSessionsDTO(TimeSession totalSessionsTime, List<SessionResponseDTO> listSessions) {
}
