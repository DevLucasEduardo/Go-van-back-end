package com.example.demo.repository;

import com.example.demo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Login, que fornece métodos para acessar dados relacionados a login no banco de dados.
 *
 * Este repositório estende JpaRepository, o que permite operações de CRUD (Create, Read, Update, Delete) em objetos da classe Login.
 *
 * @author Lucas Eduardo Pereira
 * @version 1.0
 * @since 2023-11-08
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    /**
     * Encontra um objeto Login no banco de dados com base no endereço de e-mail fornecido.
     *
     * @param email O endereço de e-mail a ser pesquisado.
     * @return O objeto Login correspondente ao endereço de e-mail fornecido.
     */
    Login findByEmail(String email);
}
