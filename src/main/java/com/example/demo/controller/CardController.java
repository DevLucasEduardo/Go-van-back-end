package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.CardDTO;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    // Classe que atua como um controlador para manipular operações relacionadas a cartões.

    @Autowired
    CardRepository cardRepository;
    // Injeção de dependência do repositório de cartões para acessar e manipular dados de cartões.

    @GetMapping("/")
    public ResponseEntity<List<CardDTO>> getAllCards() {
        // Método que lida com solicitações GET para obter todos os cartões.
        return ResponseEntity.status(HttpStatus.OK).body(cardRepository.findAll().stream().map(CardDTO::new).toList());
        // Retorna uma lista de cartões mapeados para objetos CardDTO e envia como resposta HTTP 200 (OK).
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCardById(@PathVariable Long id) {
        // Método que lida com solicitações GET para obter um cartão com um ID específico.
        Card cardValidation = cardRepository.findById(id).orElse(null);
        if (cardValidation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CardDTO(cardValidation));
        // Retorna o cartão encontrado com o ID especificado ou uma mensagem "Not found!" com a resposta HTTP apropriada.
    }

    @PostMapping("/")
    public ResponseEntity<CardDTO> postCard(@RequestBody Card card) {
        // Método que lida com solicitações POST para criar um novo cartão.
        return ResponseEntity.status(HttpStatus.CREATED).body(new CardDTO(cardRepository.save(card)));
        // Cria um novo cartão, salva no repositório e retorna o cartão criado com a resposta HTTP 201 (Created).
    }

    @PutMapping("/")
    public ResponseEntity<CardDTO> putCard(@RequestBody Card card) {
        // Método que lida com solicitações PUT para atualizar um cartão existente.
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CardDTO(cardRepository.save(card)));
        // Atualiza o cartão no repositório e retorna o cartão atualizado com a resposta HTTP 202 (Accepted).
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable Long id) {
        // Método que lida com solicitações DELETE para excluir um cartão com um ID específico.
        Card cardValidation = cardRepository.findById(id).orElse(null);
        if (cardValidation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
        }
        cardRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        // Exclui o cartão com o ID especificado e retorna uma mensagem "Deleted!" com a resposta HTTP apropriada.
    }
}


