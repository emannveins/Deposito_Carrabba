package com.concessionario.dto;

public record ClienteResponseDTO( Long id, String nome, String cognome, String email, String concessionarioNome, String concessionarioCitta, String casaMadreNome) {
    
}