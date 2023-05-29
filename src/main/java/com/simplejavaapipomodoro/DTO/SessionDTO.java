package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.entities.TimeSession;

public record SessionDTO(String title, TimeSession timeSession) {
}
