package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.UserLoginDTO;
import com.simplejavaapipomodoro.DTO.UserRequestDTO;
import com.simplejavaapipomodoro.DTO.UserResponseDTO;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(UserRequestDTO userRequestDTO){
        userRepository.save(new User(userRequestDTO));
    }

    public Optional<User> UserLogin(UserLoginDTO userLoginDTO){
        Optional<User> user = userRepository.findByNickName(userLoginDTO.nickName());
        if(user.isPresent() && user.get().getPassword().equals(userLoginDTO.password())){
            return user;
        }
        return Optional.empty();
    }
}
