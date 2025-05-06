package com.crimeinvestigation.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")  // This responds to GET http://localhost:8080/
    public Map<String, String> homePage() {
        return Map.of("message", "Welcome to the Crime Investigation System");
    }
}
