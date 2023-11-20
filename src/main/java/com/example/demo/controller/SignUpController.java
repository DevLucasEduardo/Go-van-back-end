package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign")
public class SignUpController {

    @Autowired
    LoginRepository loginRepository;

    // Endpoint to handle user registration
    @PostMapping("/")
    public ResponseEntity<Object> postUser(@RequestBody Login login) {
        // Check if the email already exists in the database
        Login emailValidation = loginRepository.findByEmail(login.getEmail());

        // If email exists, return CONFLICT status with a message
        if (emailValidation != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail already registered!");
        }

        // If email doesn't exist, save the new user and return CREATED status with the saved user details
        Login savedLogin = loginRepository.save(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginDTO(savedLogin));
    }
}

