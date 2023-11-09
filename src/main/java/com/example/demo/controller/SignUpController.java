package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class SignUpController {

    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/")
    public ResponseEntity<LoginDTO> postUser(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginDTO(loginRepository.save(login)));
    }
}
