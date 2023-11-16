package com.cst438.controller;

import com.cst438.dto.AccountCredentialsDTO;
import com.cst438.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountCredentialsDTO credentials) {
        String token = authenticationService.authenticate(credentials.getUsername(), credentials.getPassword());
        return ResponseEntity.ok(token); // Return the token in the response
    }
}
