package com.crimeinvestigation.system.controller;


import com.crimeinvestigation.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/first_lastname/{email}")
    public ResponseEntity<String> getFirst_LastName (@PathVariable("email") String email) {

        String first_lastName = userService.getFirst_LastNameByEmail(email);
        if (first_lastName == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(first_lastName);
    }

}
