package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.*;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.services.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        Optional<UserResponseDTO> responseDTO = userService.createUser(new User(userRequestDTO));
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDTO> UserLogin(@RequestBody @Valid LoginDTO loginDTO){
        Optional<UserResponseDTO> responseDTO = userService.UserLogin(loginDTO.nickName(), loginDTO.password());
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "user/{userEmail}")
    public ResponseEntity<String> deleteUser(@PathVariable String userEmail, @RequestBody @Valid UserRequestDTO userRequestDTO){
        Optional<String> response = userService.deleteUser(userEmail, userRequestDTO.password());
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "user/password")
    public ResponseEntity<String> changeUserPassword(@RequestBody @Valid EmailPasswordsDTO EmailPasswordsDTO){
        Optional<String> response = userService.changeUserPassword(
                EmailPasswordsDTO.email(),
                EmailPasswordsDTO.oldPassword(),
                EmailPasswordsDTO.newPassword()
        );

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
