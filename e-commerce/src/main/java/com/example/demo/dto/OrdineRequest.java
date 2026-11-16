package com.example.demo.dto;

public record OrdineRequest(
    Long utenteId,
    Long prodottoId,
    Integer quantita,
    String stato
) {
}