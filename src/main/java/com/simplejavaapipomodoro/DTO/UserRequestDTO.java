package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.constants.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(Long id,
                             @NotBlank(message = "cannot be blank") String firstName,
                             String lastName,
                             @NotBlank(message = "cannot be blank") String nickName,
                             @NotBlank(message = "cannot be blank") String password,
                             @NotBlank(message = "cannot be blank") @Email(message = "invalid")
                             String email,
                             Gender gender,
                             String birthDate) {
}
