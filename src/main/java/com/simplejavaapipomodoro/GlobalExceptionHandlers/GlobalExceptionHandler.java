package com.simplejavaapipomodoro.GlobalExceptionHandlers;

import com.simplejavaapipomodoro.DTO.GlobalErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalErrorDTO handleValidationExceptions(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField() +  ": " + x.getDefaultMessage()).toList();

        return new GlobalErrorDTO(HttpStatus.BAD_REQUEST, errors);
    }
}
