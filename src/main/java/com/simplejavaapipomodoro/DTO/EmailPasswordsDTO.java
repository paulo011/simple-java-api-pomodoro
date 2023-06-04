package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailPasswordsDTO(@NotBlank @Email String email, @NotBlank String oldPassword, @NotBlank String newPassword) {
}
