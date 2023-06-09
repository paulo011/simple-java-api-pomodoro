package com.simplejavaapipomodoro.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank(message = "cannot be blank") String nickName,
                       @NotBlank(message = "cannot be blank") String password) {
}
