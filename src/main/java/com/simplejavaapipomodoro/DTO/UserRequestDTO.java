package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.constants.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(Long id, @NotBlank String firstName, String lastName, @NotBlank String nickName, @NotBlank String password, @NotBlank @Email String email, Gender gender, String birthDate) {
}
