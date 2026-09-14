package com.example.cloneproject.service.security;

import com.example.cloneproject.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;
@Service
public class JwtService {
    private final String SECRET_KEY = "your_secret_key";
    // Replace with your actual secret
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()
                + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public String extractUsername(String token){
        return extractAllClaims(token)
                .getSubject();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

