package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.model.LoginDTO;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para autenticação de login de usuário.
 *
 * @author Lucas Eduardo Pereira
 * @version 1.0
 * @since 2023-11-08
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    LoginRepository loginRepository;


    /**
     * Manipula uma solicitação POST para autenticação de login de usuário.
     *
     * @param request O corpo da solicitação contendo email e senha.
     * @return Uma resposta indicando se o login foi bem-sucedido ou falhou.
     */
    @PostMapping("/")
    public ResponseEntity<Object> login(@RequestBody LoginDTO request) {
        if (loginService.isUserValid(request.email(), request.password())) {
            Login loginInfo = loginRepository.findByEmail(request.email());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new LoginDTO(loginInfo));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
        }
    }
}




