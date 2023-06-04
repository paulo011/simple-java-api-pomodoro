package com.simplejavaapipomodoro.DTO;

import org.springframework.http.HttpStatus;

import java.util.List;

public record GlobalErrorDTO(HttpStatus StatusCode, List<String> message) {
}
