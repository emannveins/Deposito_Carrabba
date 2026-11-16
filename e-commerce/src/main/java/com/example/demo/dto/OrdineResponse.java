package com.example.demo.dto;

import java.time.LocalDateTime;

public record OrdineResponse(
    Long id,
    Long utenteId,
    Long prodottoId,
    Integer quantita,
    LocalDateTime dataOrdine,
    String stato
) {
}
