
package com.concessionario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concessionario.entity.CasaMadre;
import com.concessionario.repository.CasaMadreRepository;
import com.concessionario.repository.ConcessionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CasaMadreService {

    private final CasaMadreRepository casaMadreRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public CasaMadreService(CasaMadreRepository casaMadreRepository, ConcessionarioRepository concessionarioRepository) {
        this.casaMadreRepository = casaMadreRepository;
        this.concessionarioRepository = concessionarioRepository;
    }

    public CasaMadre create(CasaMadre casaMadre) {
        validate(casaMadre);
        casaMadre.setId(null);
        return casaMadreRepository.save(casaMadre);
    }

    public List<CasaMadre> findAll() {
        return casaMadreRepository.findAll();
    }

    public CasaMadre findById(Long id) {
        return casaMadreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "casa madre non trovata: " + id
                    ));
    }

    public CasaMadre update(Long id, CasaMadre nuovaCasaMadre) {
        validate(nuovaCasaMadre);
        CasaMadre casaMadre = findById(id);
        casaMadre.setRagioneSociale(nuovaCasaMadre.getRagioneSociale());
        casaMadre.setSedeLegale(nuovaCasaMadre.getSedeLegale());
        casaMadre.setPaese(nuovaCasaMadre.getPaese());
        casaMadre.setAnnoFondazione(nuovaCasaMadre.getAnnoFondazione());
        casaMadre.setFatturatoAnnuo(nuovaCasaMadre.getFatturatoAnnuo());
        return casaMadreRepository.save(casaMadre);
    }

    public void delete(Long id) {
        CasaMadre casaMadre = findById(id);
        if (concessionarioRepository.existsByCasaMadre_Id(id)) {
            throw new IllegalStateException(
                "impossibile eliminare"
            );
        }
        casaMadreRepository.delete(casaMadre);
    }

    private void validate(CasaMadre casaMadre) {

        if (casaMadre == null) {
            throw new IllegalArgumentException(
                "dati casa madre obbligatori!"
            );
        }

        if (casaMadre.getRagioneSociale() == null || casaMadre.getRagioneSociale().isBlank()) {
            throw new IllegalArgumentException(
                "regione sociale obbligatoria!"
            );
        }

        if (casaMadre.getSedeLegale() == null || casaMadre.getSedeLegale().isBlank()) {
            throw new IllegalArgumentException(
                "sede legale obbligatoria!"
            );
        }

        if (casaMadre.getPaese() == null || casaMadre.getPaese().isBlank()) {
            throw new IllegalArgumentException(
                "paese obbligatorio!"
            );
        }
    }
}
