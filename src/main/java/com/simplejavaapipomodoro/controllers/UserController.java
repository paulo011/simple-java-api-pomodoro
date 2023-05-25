package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.UserLoginDTO;
import com.simplejavaapipomodoro.DTO.UserRequestDTO;
import com.simplejavaapipomodoro.DTO.UserResponseDTO;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.UserRepository;
import com.simplejavaapipomodoro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserRequestDTO body){
        userService.create(body);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO){
        Optional<User> response = userService.UserLogin(userLoginDTO);
        if(response.isPresent()){
            UserResponseDTO userResponseDTO = new UserResponseDTO(response.get().getId(),response.get().getFirstName(),response.get().getLastName(),response.get().getNickName(),response.get().getEmail(),response.get().getGender(),response.get().getBirthDate());
            return ResponseEntity.ok(userResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
