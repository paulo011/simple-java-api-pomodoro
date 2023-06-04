package com.simplejavaapipomodoro.GlobalExceptionHandlers;

import com.simplejavaapipomodoro.DTO.GlobalErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GlobalErrorDTO handleValidationExceptions(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<String> errors = new ArrayList<>();
        for(FieldError fieldError : fieldErrors){
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        return new GlobalErrorDTO(HttpStatus.BAD_REQUEST, errors);
    }
}
