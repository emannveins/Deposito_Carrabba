package com.example.demo.dto;

public record ProdottoResponse(
    Long id,
    String nome,
    String descrizione,
    boolean disponibile
) {
}