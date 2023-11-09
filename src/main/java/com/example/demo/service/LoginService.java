package com.example.demo.service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço para validação de autenticação de login de usuário.
 *
 * @author Lucas Eduardo Pereira
 * @version 1.0
 * @since 2023-11-08
 */
@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    /**
     * Verifica se um usuário é válido com base no email e senha fornecidos.
     *
     * @param email    O endereço de e-mail do usuário.
     * @param password A senha do usuário.
     * @return `true` se o usuário for válido, `false` caso contrário.
     */
    public boolean isUserValid(String email, String password) {

        Login login = loginRepository.findByEmail(email);

        return login != null && login.getPassword().equals(password);
    }
}
