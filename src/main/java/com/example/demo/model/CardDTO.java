package com.example.demo.model;

public record CardDTO(Long id,
                      String vehicle,
                      String licensePlate,
                      String departureLocation,
                      String destination,
                      Integer availableSeats,
                      String departureDate,
                      String departureTime,
                      Boolean accessibility) {
    // Esta classe "CardDTO" é um registro (record) que representa um objeto de transferência de dados (DTO) para informações de cartões.

    // Construtor que recebe um objeto "Card" e inicializa um objeto "CardDTO" a partir dele.
    public CardDTO(Card card) {
        // O construtor recebe um objeto "Card" como parâmetro e utiliza seus dados para inicializar um objeto "CardDTO".
        this(
                card.getId(),               // Atribui o ID do objeto "Card" ao ID do "CardDTO".
                card.getVehicle(),          // Atribui o veículo do objeto "Card" ao veículo do "CardDTO".
                card.getLicensePlate(),     // Atribui a placa de licença do objeto "Card" à placa de licença do "CardDTO".
                card.getDepartureLocation(), // Atribui o local de partida do objeto "Card" ao local de partida do "CardDTO".
                card.getDestination(),      // Atribui o destino do objeto "Card" ao destino do "CardDTO".
                card.getAvailableSeats(),   // Atribui o número de assentos disponíveis do objeto "Card" aos assentos disponíveis do "CardDTO".
                card.getDepartureDate(),    // Atribui a data de partida do objeto "Card" à data de partida do "CardDTO".
                card.getDepartureTime(),    // Atribui o horário de partida do objeto "Card" ao horário de partida do "CardDTO".
                card.getAccessibility()     // Atribui a acessibilidade do objeto "Card" à acessibilidade do "CardDTO".
        );
    }
}


