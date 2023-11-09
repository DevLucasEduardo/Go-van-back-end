package com.example.demo.model;

/**
 * Esta classe é uma DTO e tem por função evitar a exposição dos dados.
 * Ela é definida como um "record" em Java, que é uma classe imutável que armazena dados.
 *
 * @author Lucas Eduardo Pereira
 * @version 1.0
 * @since 2023-11-07
 */
public record LoginDTO(Long id, String email, String password, String company) {
    /**
     * Construtor que recebe um objeto "Login" e inicializa um objeto "LoginDTO" a partir dele.
     *
     * @param login O objeto "Login" do qual os dados serão copiados para inicializar o "LoginDTO".
     */
    public LoginDTO(Login login) {
        this(
                login.getId(),         // Atribui o ID do objeto "Login" ao ID do "LoginDTO".
                login.getEmail(),      // Atribui o email do objeto "Login" ao email do "LoginDTO".
                login.getPassword(),   // Atribui a senha do objeto "Login" à senha do "LoginDTO".
                login.getCompany()    // Atribui o nome da empresa do objeto "Login" ao nome da empresa do "LoginDTO".
        );
    }
}



