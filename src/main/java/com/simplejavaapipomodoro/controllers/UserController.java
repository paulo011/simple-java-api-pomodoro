package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.*;
import com.simplejavaapipomodoro.entities.User;
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
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        Optional<UserResponseDTO> responseDTO = userService.createUser(new User(userRequestDTO));
        if (responseDTO.isEmpty()){
            return ResponseEntity.badRequest().body(new ErrorDTO(400, "email or nickName already exists"));
        }
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDTO> UserLogin(@RequestBody LoginDTO loginDTO){
        Optional<UserResponseDTO> responseDTO = userService.UserLogin(loginDTO.nickName(), loginDTO.password());
        return responseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping(value = "user/{userEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable String userEmail, @RequestBody UserRequestDTO userRequestDTO){
        Optional<String> response = userService.deleteUser(userEmail, userRequestDTO.password());
        if (response.isEmpty()){
            return ResponseEntity.badRequest().body(new ErrorDTO(400, "email or password incorrect"));
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "user/password")
    public ResponseEntity<?> changeUserPassword(@RequestBody EmailPasswordsDTO EmailPasswordsDTO){
        Optional<String> response = userService.changeUserPassword(
                EmailPasswordsDTO.email(),
                EmailPasswordsDTO.oldPassword(),
                EmailPasswordsDTO.newPassword()
        );
        if(response.isEmpty()){
            return ResponseEntity.badRequest().body(new ErrorDTO(400, "password already exist or too short password"));
        }
        return ResponseEntity.ok(response);
    }
}
