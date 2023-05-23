package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.constants.Gender;

public record UserRequestDTO(String firstName, String lastName, String nickName, String password, String email, Gender gender, String birthDate) {
}
