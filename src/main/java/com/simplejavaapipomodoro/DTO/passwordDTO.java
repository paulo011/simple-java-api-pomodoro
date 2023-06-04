package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record passwordDTO(@NotBlank String password) {
}
