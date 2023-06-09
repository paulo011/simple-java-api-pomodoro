package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record passwordDTO(@NotBlank(message = "cannot be blank") String password) {
}
