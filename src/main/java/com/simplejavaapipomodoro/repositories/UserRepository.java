package com.simplejavaapipomodoro.repositories;

import com.simplejavaapipomodoro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickName(String nickName);
    Optional<User> findByEmail(String email);
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_user u SET u.password = :newPassword WHERE u.email = :email")
    int updateUserPassword(@Param("email") String email, @Param("newPassword") String newPassword);

}
