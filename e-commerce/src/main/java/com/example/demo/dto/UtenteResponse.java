package com.example.demo.dto;

public record UtenteResponse(
    Long id,
    String nome,
    String cognome,
    String email
) {
}
