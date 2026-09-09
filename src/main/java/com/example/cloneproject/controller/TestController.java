package com.example.cloneproject.controller;

import com.example.cloneproject.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestService TestService;

    public TestController(TestService testService) {
        TestService = testService;
    }

    @GetMapping("/test")
    public String hello(){
        return TestService.getMessage();
    }
}
