package com.simplejavaapipomodoro.repositories;

import com.simplejavaapipomodoro.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "SELECT * FROM tb_session WHERE tb_session.user_id = :userId")
    Optional<List<Session>> findAllByUserId(@Param("userId") Long UserId);
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tb_session WHERE tb_session.user_id = :userId")
    void deleteAllByUserId(@Param("userId") Long UserId);
}
