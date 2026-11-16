
package com.concessionario.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.concessionario.dto.CasaMadreResponseDTO;
import com.concessionario.dto.ClienteResponseDTO;
import com.concessionario.dto.ConcessionarioResponseDTO;
import com.concessionario.entity.CasaMadre;
import com.concessionario.entity.Cliente;
import com.concessionario.entity.Concessionario;

@Component
public class EntityDtoMapper {

    public ClienteResponseDTO toClienteDTO(Cliente cliente) {  Concessionario concessionario = cliente.getConcessionario();

        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCognome(),
            cliente.getEmail(),
            concessionario.getNome(),
            concessionario.getCitta(),
            concessionario.getCasaMadre().getRagioneSociale()
        );
    }

    public ConcessionarioResponseDTO toConcessionarioDTO(Concessionario concessionario) {

        Long numeroClienti = (long) concessionario.getClienti().size();
        return new ConcessionarioResponseDTO(
            concessionario.getId(),
            concessionario.getNome(),
            concessionario.getCitta(),
            concessionario.getFatturato(),
            concessionario.getCasaMadre().getRagioneSociale(),
            numeroClienti
        );
    }

    public CasaMadreResponseDTO toCasaMadreDTO(CasaMadre casaMadre) {

        List<Concessionario> concessionari = casaMadre.getConcessionari();
        Long numeroConcessionari = (long) concessionari.size();
        BigDecimal fatturatoTotale = concessionari.stream()
                .map(Concessionario::getFatturato)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CasaMadreResponseDTO(
            casaMadre.getId(),
            casaMadre.getRagioneSociale(),
            casaMadre.getPaese(),
            casaMadre.getFatturatoAnnuo(),
            numeroConcessionari,
            fatturatoTotale
        );
    }
}
