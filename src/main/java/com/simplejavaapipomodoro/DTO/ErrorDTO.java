package com.simplejavaapipomodoro.DTO;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record ErrorDTO(HttpStatus httpStatus, List<String> messages) {
    public ErrorDTO(HttpStatus httpStatus, String messages){
        this(httpStatus, Collections.singletonList(messages));
    }
}
