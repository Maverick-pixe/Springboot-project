package com.example.cloneproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TestService {
    public String getMessage(){
        return "Hello From TestService!";
    }
}
