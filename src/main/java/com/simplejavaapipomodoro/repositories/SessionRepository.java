package com.simplejavaapipomodoro.repositories;

import com.simplejavaapipomodoro.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
