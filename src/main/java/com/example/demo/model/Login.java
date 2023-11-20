package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe representa uma entidade JPA que mapeia informações de login para uma tabela no banco de dados.
 *
 * @author Lucas Eduardo Pereira
 * @version 1.0
 * @since 2023-11-07
 *
 * A classe `Login` é responsável por mapear informações de login, como endereço de e-mail, senha e nome da empresa,
 * para uma tabela no banco de dados. Ela é uma entidade JPA, o que permite a interação com o banco de dados
 * usando o framework JPA.
 */
@Entity
@Table(name = "info_user")
@Getter
@Setter
public class Login {

    /**
     * Identificador único da entrada de login.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * O endereço de e-mail do usuário.
     */
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    /**
     * A senha do usuário.
     */
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    /**
     * O nome do usuário.
     */
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;
}
