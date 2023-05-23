package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.constants.Gender;

public record UserResponseDTO(String firstName, String lastName, String nickName, String email, Gender gender, String birthDate) {
}
