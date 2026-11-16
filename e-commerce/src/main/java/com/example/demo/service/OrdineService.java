package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Ordine;
import com.example.demo.model.Prodotto;
import com.example.demo.model.Utente;
import com.example.demo.repository.OrdineRepository;
import com.example.demo.repository.ProdottoRepository;
import com.example.demo.repository.UtenteRepository;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final UtenteRepository utenteRepository;
    private final ProdottoRepository prodottoRepository;

    public OrdineService(
            OrdineRepository ordineRepository,
            UtenteRepository utenteRepository,
            ProdottoRepository prodottoRepository) {

        this.ordineRepository = ordineRepository;
        this.utenteRepository = utenteRepository;
        this.prodottoRepository = prodottoRepository;
    }

    // METODO 1: recupera tutti gli ordini
    public List<Ordine> getAllOrdini() {
        return ordineRepository.findAll();
    }

    // METODO 2: cerca un ordine tramite ID
    public Optional<Ordine> getOrdineById(Long id) {
        return ordineRepository.findById(id);
    }

    // METODO 3: crea un ordine
    public Ordine creaOrdine(
            Long utenteId,
            Long prodottoId,
            Integer quantita,
            String stato) {

        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Utente non trovato"));

        Prodotto prodotto = prodottoRepository.findById(prodottoId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Prodotto non trovato"));

        Ordine ordine = new Ordine();

        ordine.setUtente(utente);
        ordine.setProdotto(prodotto);
        ordine.setQuantita(quantita);
        ordine.setDataOrdine(LocalDateTime.now());
        ordine.setStato(stato);

        return ordineRepository.save(ordine);
    }
}