package com.simplejavaapipomodoro.repository;

import com.simplejavaapipomodoro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
