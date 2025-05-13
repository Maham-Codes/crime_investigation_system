package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.dto.InvestigatorSignupRequest;
import com.crimeinvestigation.system.dto.UserSignupRequest;
import com.crimeinvestigation.system.model.Investigator;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/check")
    public String check() {
        return "Hello World";
    }

    @Autowired
    private AuthService authService;

    @PostMapping("/investigator/signup")
    public ResponseEntity<?> investigatorSignup(@RequestBody InvestigatorSignupRequest request) {
        Investigator saved = authService.registerInvestigator(request);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> userSignup(@RequestBody UserSignupRequest request) {
        User saved = authService.registerUser(request);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/investigator/login")
    public ResponseEntity<?> investigatorLogin(@RequestParam String email, @RequestParam String password) {
        Investigator inv = authService.loginInvestigator(email, password);
        if (inv != null) return ResponseEntity.ok(inv);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> userLogin(@RequestParam String email, @RequestParam String password) {
        User user = authService.loginUser(email, password);
        if (user != null) return ResponseEntity.ok(user);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}

