package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.UserResponseDTO;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.SessionRepository;
import com.simplejavaapipomodoro.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public Optional<UserResponseDTO> createUser(User user){
        Optional<User> emailExists = userRepository.findByEmail(user.getEmail());
        if(emailExists.isPresent()) return Optional.empty();

        User userCreated = userRepository.save(user);
        return Optional.of(new UserResponseDTO(userCreated));
    }

    public Optional<UserResponseDTO> UserLogin(String nickName, String password){
        Optional<User> user = userRepository.findByNickName(nickName);

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return Optional.of(new UserResponseDTO(user));
        }
        return Optional.empty();
    }

    public Optional<String> deleteUser(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent() && user.get().getPassword().equals(password)){
            Long userId = user.get().getId();
            sessionRepository.deleteAllByUserId(userId);
            userRepository.deleteById(userId);
            return Optional.of("User deleted");
        }
        return Optional.empty();
    }

    public Optional<String> changeUserPassword(String email, String oldPassword, String newPassword){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent() && user.get().getPassword().equals(oldPassword)) {
            if(!user.get().getPassword().equals(newPassword)){
                user.get().setPassword(newPassword);
                return Optional.of("successfully changed password");
            }
        }
        return Optional.empty();
    }
}
