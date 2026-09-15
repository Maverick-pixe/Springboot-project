package com.example.cloneproject.service.security;

import com.example.cloneproject.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Service
public class JwtService {
    private static final String SECRET_KEY = "your_secret_key";
    // Replace with your actual secret
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(String email){
        return builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()
                + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public static String extractUsername(String token){
        return extractAllClaims(token)
                .getSubject();
    }

    private static Claims extractAllClaims(String token){
        return parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

