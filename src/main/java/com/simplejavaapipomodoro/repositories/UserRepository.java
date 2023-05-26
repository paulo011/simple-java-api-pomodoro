package com.simplejavaapipomodoro.repositories;

import com.simplejavaapipomodoro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickName(String nickName);
}
