package com.concessionario.dto;

import java.math.BigDecimal;

public record CasaMadreResponseDTO(Long id, String ragioneSociale, String paese, BigDecimal fatturatoAnnuo, Long numeroConcessionari, BigDecimal fatturatoTotaleConcessionari) {
    
}