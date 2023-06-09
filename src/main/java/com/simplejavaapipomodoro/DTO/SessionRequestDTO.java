package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record SessionRequestDTO(@NotBlank(message = "cannot be blank") String title,
                                @NotBlank(message = "cannot be blank") String timeSession) {
}
