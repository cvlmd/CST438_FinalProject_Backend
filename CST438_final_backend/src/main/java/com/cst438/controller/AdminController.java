package com.cst438.controller;

import com.cst438.dto.AccountCredentialsDTO;
import com.cst438.dto.AttemptDTO;
import com.cst438.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody AccountCredentialsDTO credentials) {
        // The adminService will take the credentials DTO, create a new user, and save it
        adminService.createUser(credentials);
        // Return a response entity with HTTP status 201 (Created) if successful
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/attempts")
    public ResponseEntity<List<AttemptDTO>> getAllAttempts() {
        // Retrieve all attempts using the adminService
        List<AttemptDTO> attempts = adminService.getAllAttempts();
        // Return a response entity with the list of attempts and HTTP status 200 (OK)
        return ResponseEntity.ok(attempts);
    }
}
