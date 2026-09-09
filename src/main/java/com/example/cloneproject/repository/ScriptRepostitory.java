package com.example.cloneproject.repository;

import com.example.cloneproject.entity.Script;
import com.example.cloneproject.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScriptRepostitory extends JpaRepository<Script,Id> {
    List<Script> findByUser(User user);
}
