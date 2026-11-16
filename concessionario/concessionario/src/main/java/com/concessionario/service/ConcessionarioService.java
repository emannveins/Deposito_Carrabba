
package com.concessionario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concessionario.entity.CasaMadre;
import com.concessionario.entity.Concessionario;
import com.concessionario.repository.CasaMadreRepository;
import com.concessionario.repository.ClienteRepository;
import com.concessionario.repository.ConcessionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConcessionarioService {

    private final ConcessionarioRepository concessionarioRepository;
    private final CasaMadreRepository casaMadreRepository;
    private final ClienteRepository clienteRepository;

    public ConcessionarioService( ConcessionarioRepository concessionarioRepository, CasaMadreRepository casaMadreRepository, ClienteRepository clienteRepository) {
        this.concessionarioRepository = concessionarioRepository;
        this.casaMadreRepository = casaMadreRepository;
        this.clienteRepository = clienteRepository;
    }

    public Concessionario create(Concessionario concessionario) {
        validate(concessionario);
        CasaMadre casaMadre = casaMadreRepository.findById(
                concessionario.getCasaMadre().getId()
        ).orElseThrow(() ->
                new EntityNotFoundException("casa madre non trovata")
        );
        concessionario.setId(null);
        concessionario.setCasaMadre(casaMadre);
        return concessionarioRepository.save(concessionario);
    }

    public List<Concessionario> findAll() {
        return concessionarioRepository.findAll();
    }

    public Concessionario findById(Long id) {
        return concessionarioRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "concessionario non trovato con id: " + id
                    ));
    }

    public Concessionario update(Long id, Concessionario nuovoConcessionario) {
        validate(nuovoConcessionario);
        Concessionario concessionario = findById(id);
        CasaMadre casaMadre = casaMadreRepository.findById(
                nuovoConcessionario.getCasaMadre().getId()
        ).orElseThrow(() ->
                new EntityNotFoundException("casa-madre non trovata")
        );

        concessionario.setNome(nuovoConcessionario.getNome());
        concessionario.setCitta(nuovoConcessionario.getCitta());
        concessionario.setIndirizzo(nuovoConcessionario.getIndirizzo());
        concessionario.setTelefono(nuovoConcessionario.getTelefono());
        concessionario.setFatturato(nuovoConcessionario.getFatturato());
        concessionario.setCasaMadre(casaMadre);
        return concessionarioRepository.save(concessionario);
    }

    public void delete(Long id) {
        Concessionario concessionario = findById(id);
        if (clienteRepository.existsByConcessionario_Id(id)) {
            throw new IllegalStateException(
                "impossibile eliminare: esistono clienti associati"
            );
        }
        concessionarioRepository.delete(concessionario);
    }

    private void validate(Concessionario concessionario) {
        if (concessionario == null) {
            throw new IllegalArgumentException(
                "dati concessionario obbligatori"
            );
        }
        if (concessionario.getNome() == null || concessionario.getNome().isBlank()) {
            throw new IllegalArgumentException(
                " nome concessionario obbligatorio"
            );
        }
        if (concessionario.getCitta() == null || concessionario.getCitta().isBlank()) {
            throw new IllegalArgumentException(
                "citta concessionario obbligatoria"
            );
        }
        if (concessionario.getCasaMadre() == null || concessionario.getCasaMadre().getId() == null) {
            throw new IllegalArgumentException(
                "casa madre obbligatoria"
            );
        }
    }
}
