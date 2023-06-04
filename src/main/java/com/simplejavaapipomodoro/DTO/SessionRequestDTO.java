package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record SessionRequestDTO(@NotBlank String title, @NotBlank String timeSession) {
}
