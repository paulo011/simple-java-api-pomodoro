package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.ErrorDTO;
import com.simplejavaapipomodoro.DTO.UserResponseDTO;
import com.simplejavaapipomodoro.entities.User;
import com.simplejavaapipomodoro.repositories.SessionRepository;
import com.simplejavaapipomodoro.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public ResponseEntity<?> createUser(User user){
        Optional<User> emailExists = userRepository.findByEmail(user.getEmail());
        Optional<User> nickNameExists = userRepository.findByNickName(user.getNickName());

        if(emailExists.isPresent() && nickNameExists.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "email and nickName already exists"));
        }
        if (emailExists.isPresent()){
            return ResponseEntity.badRequest()
                    .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "email already exists"));
        }
        if(nickNameExists.isPresent()){
            return ResponseEntity.badRequest()
                    .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "nickname already exists"));
        }

        User userCreated = userRepository.save(user);
        return ResponseEntity.ok(new UserResponseDTO(userCreated));
    }

    public ResponseEntity<?> UserLogin(String nickName, String password){
        Optional<User> user = userRepository.findByNickName(nickName);

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return ResponseEntity.ok(new UserResponseDTO(user));
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErrorDTO(HttpStatus.FORBIDDEN, "user denied"));
    }

    public ResponseEntity<?> deleteUser(long id, String password){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(HttpStatus.NOT_FOUND, "id not found"));

        if(user.get().getPassword().equals(password)){
            Long userId = user.get().getId();
            sessionRepository.deleteAllByUserId(userId);
            userRepository.deleteById(userId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.badRequest()
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "password incorrect"));
    }

    public ResponseEntity<?> changeUserPassword(Long id, String oldPassword, String newPassword){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(HttpStatus.NOT_FOUND, "user not found"));

        if(user.get().getPassword().equals(oldPassword)) {
            if(!user.get().getPassword().equals(newPassword)){
                user.get().setPassword(newPassword);
                return ResponseEntity.ok("successfully changed password");
            }

            return ResponseEntity.badRequest()
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST, "new password exists"));
        }

        return ResponseEntity.badRequest()
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST,"old password incorrect"));
    }
}
