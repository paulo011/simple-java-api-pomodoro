package com.simplejavaapipomodoro.controllers;

import com.simplejavaapipomodoro.DTO.*;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        return userService.createUser(new User(userRequestDTO));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> UserLogin(@RequestBody @Valid LoginDTO loginDTO){
         return userService.UserLogin(loginDTO.nickName(), loginDTO.password());
    }

    @DeleteMapping(value = "user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId, @RequestBody @Valid passwordDTO passwordDTO){
        return userService.deleteUser(userId, passwordDTO.password());
    }

    @PutMapping(value = "user/{userId}/password")
    public ResponseEntity<?> changeUserPassword(@PathVariable long userId, @RequestBody @Valid ChangePasswordDTO changePasswordDTO){
        return userService.changeUserPassword(
                userId, changePasswordDTO.oldPassword(), changePasswordDTO.newPassword());
    }
}
