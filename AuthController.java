package com.example.tourist.controller;

import com.example.tourist.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    // Demo credentials only. Replace with database-backed user authentication in production.
    @PostMapping("/token")
    public ResponseEntity<?> createToken(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if (!"admin".equals(username) || !"password123".equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }

        return ResponseEntity.ok(Map.of("token", jwtService.generateToken(username),
                                        "tokenType", "Bearer"));
    }
}
