package com.example.cloneproject.service;

import com.example.cloneproject.dto.AuthRequest;
import com.example.cloneproject.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
