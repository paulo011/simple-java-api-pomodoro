package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordDTO(@NotBlank(message = "cannot be blank") String oldPassword,
                                @NotBlank(message = "cannot be blank") String newPassword) {
}
