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
    public void createUser(@RequestBody UserRequestDTO userRequestDTO){
        userService.create(new User(userRequestDTO));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO){
        Optional<User> response = userService.UserLogin(userRequestDTO.nickName(), userRequestDTO.password());
        if(response.isPresent()){
            UserResponseDTO userResponseDTO = new UserResponseDTO(response);
            return ResponseEntity.ok(userResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "{userId}/delete")
    public void delete(@PathVariable Long userId, @RequestBody UserRequestDTO userRequestDTO){
        userService.deleteUser(userId, userRequestDTO.password());
    }

    @PutMapping(value = "/password")
    public void changePassword(@RequestBody EmailPasswordsDTO EmailPasswordsDTO){
        userService.changeUserPassword(
                EmailPasswordsDTO.email(),
                EmailPasswordsDTO.oldPassword(),
                EmailPasswordsDTO.newPassword()
        );
    }
}
