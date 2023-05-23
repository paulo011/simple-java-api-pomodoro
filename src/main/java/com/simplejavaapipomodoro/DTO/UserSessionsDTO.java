package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.Session;

import java.util.List;

public record UserSessionsDTO(String totalSessionsTime, List<Session> sessions) {
}
