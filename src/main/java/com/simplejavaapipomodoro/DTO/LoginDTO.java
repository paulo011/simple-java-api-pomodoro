package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String nickName, @NotBlank String password) {
}
