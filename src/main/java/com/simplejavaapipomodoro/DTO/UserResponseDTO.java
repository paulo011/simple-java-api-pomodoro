package com.simplejavaapipomodoro.DTO;

import com.simplejavaapipomodoro.constants.Gender;
import com.simplejavaapipomodoro.entities.User;

import java.util.Optional;

public record UserResponseDTO(Long id, String firstName, String lastName, String nickName, String email, Gender gender, String birthDate) {
    public UserResponseDTO(Optional<User> user){
        this(user.get().getId(), user.get().getFirstName(), user.get().getLastName(), user.get().getNickName(), user.get().getEmail(), user.get().getGender(), user.get().getBirthDate());
    }
    public UserResponseDTO(User user){
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getNickName(), user.getEmail(), user.getGender(), user.getBirthDate());
    }
}
