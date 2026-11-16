package com.concessionario.dto;

import java.math.BigDecimal;

public record ConcessionarioResponseDTO( Long id, String nome, String citta, BigDecimal fatturato, String casaMadreNome,Long numeroClienti) {
    
}