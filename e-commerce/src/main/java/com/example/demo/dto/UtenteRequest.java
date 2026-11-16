package com.example.demo.dto;

public record UtenteRequest(
    String nome,
    String cognome,
    String email
) {
}