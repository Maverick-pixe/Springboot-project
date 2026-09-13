package com.example.cloneproject.service.security;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import static java.util.Calendar.DATE;
import static javax.swing.text.html.HTML.Tag.S;
@Service
public class JwtService {
    private final String SECRET_KEY = "your_secret_key";
    // Replace with your actual secret
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 24 hours

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new DATE(S))
    }

}

