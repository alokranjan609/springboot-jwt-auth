package com.example.jwt_authenticate.controller;

import com.example.jwt_authenticate.dto.AuthResponse;
import com.example.jwt_authenticate.dto.LoginRequest;
import com.example.jwt_authenticate.dto.RegisterRequest;
import com.example.jwt_authenticate.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/me")
    public String securedEndpoint() {
        return "You are authenticated";
    }
}
