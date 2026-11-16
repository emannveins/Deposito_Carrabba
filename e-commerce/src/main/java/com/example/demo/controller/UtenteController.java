package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtenteRequest;
import com.example.demo.dto.UtenteResponse;
import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    // API 1: recupera tutti gli utenti
    @GetMapping
    public List<UtenteResponse> getAllUtenti() {
        return utenteService.getAllUtenti()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // API 2: recupera un utente tramite ID
    @GetMapping("/{id}")
    public ResponseEntity<UtenteResponse> getUtenteById(
            @PathVariable Long id) {

        return utenteService.getUtenteById(id)
                .map(utente -> ResponseEntity.ok(toResponse(utente)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // API 3: crea un nuovo utente
    @PostMapping
    public ResponseEntity<UtenteResponse> creaUtente(
            @RequestBody UtenteRequest request) {

        Utente utente = new Utente();
        utente.setNome(request.nome());
        utente.setCognome(request.cognome());
        utente.setEmail(request.email());

        Utente salvato = utenteService.creaUtente(utente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(salvato));
    }

    // Converte una Entity nel DTO di risposta
    private UtenteResponse toResponse(Utente utente) {
        return new UtenteResponse(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getEmail()
        );
    }
}