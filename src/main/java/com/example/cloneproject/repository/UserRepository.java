package com.example.cloneproject.repository;

import com.example.cloneproject.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
