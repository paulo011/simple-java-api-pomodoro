package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailPasswordsDTO(@NotBlank(message = "cannot be blank") @Email(message = "invalid") String email,
                                @NotBlank(message = "cannot be blank") String oldPassword,
                                @NotBlank(message = "cannot be blank") String newPassword) {
}
