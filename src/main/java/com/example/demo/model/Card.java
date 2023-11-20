package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Esta classe representa uma entidade que mapeia informações de cartões para uma tabela no banco de dados.

@Setter
@Getter
@Entity
@Table(name = "Card")
public class Card {

    // Identificador único do cartão.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O veículo associado ao cartão.
    @Column(name = "vehicle", length = 100, nullable = false)
    private String vehicle;

    // A placa de licença do veículo associado ao cartão.
    @Column(name = "license plate", length = 7, nullable = false)
    private String licensePlate;

    // O local de partida do cartão.
    @Column(name = "departure location", length = 255, nullable = false)
    private String departureLocation;

    // O destino do cartão.
    @Column(name = "destination", length = 255, nullable = false)
    private String destination;

    // O número de assentos disponíveis no veículo associado ao cartão.
    @Column(name = "available seats", nullable = false)
    private Integer availableSeats;

    // A data de partida da viagem associada ao cartão.
    @Column(name = "departure date", length = 255, nullable = false)
    private String departureDate;

    // O horário de partida da viagem associada ao cartão.
    @Column(name = "departure time", length = 255, nullable = false)
    private String departureTime;

    // Indica se o veículo associado ao cartão possui acessibilidade (verdadeiro ou falso).
    @Column(name = "Accessibility", nullable = false)
    private Boolean accessibility;
}

