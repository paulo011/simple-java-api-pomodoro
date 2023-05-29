package com.simplejavaapipomodoro.services;

import com.simplejavaapipomodoro.DTO.UserSessionsDTO;
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

    public void create(User user){
        userRepository.save(user);
    }

    public Optional<User> UserLogin(String nickName, String password){
        Optional<User> user = userRepository.findByNickName(nickName);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            return user;
        }
        return Optional.empty();
    }

    public void deleteUser(Long id, String password){
        // TODO: criar forma de excluir todos os sessions que tem o relacionamento com o user [RESOLVER]
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            System.out.println(user.get().getId());
            userRepository.deleteById(id);
        }
    }

    public void changeUserPassword(String email, String oldPassword, String newPassword){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && user.get().getPassword().equals(oldPassword)) {
            int i = userRepository.updateUserPassword(email, newPassword);
        }
    }
}
