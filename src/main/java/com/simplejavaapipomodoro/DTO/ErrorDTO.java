package com.simplejavaapipomodoro.DTO;

import org.springframework.http.HttpStatus;

public record ErrorDTO(HttpStatus statusCode, String message) {
}
