package com.example.cloneproject.service;

import com.example.cloneproject.dto.AuthRequest;
import com.example.cloneproject.dto.AuthResponse;
import com.example.cloneproject.entity.User;
import com.example.cloneproject.entity.UserPlan;
import com.example.cloneproject.entity.UserRole;
import com.example.cloneproject.repository.UserRepository;
import com.example.cloneproject.service.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(AuthRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            return new AuthResponse(" Email already exists ", null);
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .plan(UserPlan.FREE)
                .build();

        userRepository.save(user);
        // Continue with registration logic
        return new AuthResponse(" Registration successful ", null);
    }

    @Override

    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return new AuthResponse("Invalid email or password", null);
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return new AuthResponse("Invalid email or password", null);
        }
        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse("Login successful", token);
    }
}