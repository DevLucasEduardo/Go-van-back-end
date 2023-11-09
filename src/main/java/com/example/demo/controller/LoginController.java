package com.example.demo.controller;

import com.example.demo.model.LoginDTO;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Manipula uma solicitação POST para autenticação de login de usuário.
     *
     * @param request O corpo da solicitação contendo email e senha.
     * @return Uma resposta indicando se o login foi bem-sucedido ou falhou.
     */
    @PostMapping("/")
    public String login(@RequestBody LoginDTO request) {
        if (loginService.isUserValid(request.email(), request.password())) {
            return "Successfully logged";
        } else {
            return "Login failed";
        }
    }
}




