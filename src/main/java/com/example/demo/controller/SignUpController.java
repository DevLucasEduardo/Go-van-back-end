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

    // Endpoint para lidar com o registro do usuário
    @PostMapping("/")
    public ResponseEntity<Object> postUser(@RequestBody Login login) {
        // Verifica se o e-mail já existe no banco de dados
        Login emailValidation = loginRepository.findByEmail(login.getEmail());

        // Se o e-mail existir, retorna o status CONFLICT com uma mensagem
        if (emailValidation != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail already registered!");
        }

        // Se o e-mail não existir, salva o novo usuário e retorna o status CREATED com os detalhes do usuário salvo

        Login savedLogin = loginRepository.save(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginDTO(savedLogin));
    }
}

