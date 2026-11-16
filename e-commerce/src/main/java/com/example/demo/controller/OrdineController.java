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

import com.example.demo.dto.OrdineRequest;
import com.example.demo.dto.OrdineResponse;
import com.example.demo.model.Ordine;
import com.example.demo.service.OrdineService;

@RestController
@RequestMapping("/ordini")
public class OrdineController {

    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    // API 1: recupera tutti gli ordini
    @GetMapping
    public List<OrdineResponse> getAllOrdini() {
        return ordineService.getAllOrdini()
                .stream()
                .map(this::toResponse)
                .toList();
    }
    // API 2: recupera un ordine tramite ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdineResponse> getOrdineById(
            @PathVariable Long id) {

        return ordineService.getOrdineById(id)
                .map(ordine ->
                        ResponseEntity.ok(toResponse(ordine)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // API 3: crea un ordine
    @PostMapping
    public ResponseEntity<OrdineResponse> creaOrdine(
            @RequestBody OrdineRequest request) {

        Ordine salvato = ordineService.creaOrdine(
                request.utenteId(),
                request.prodottoId(),
                request.quantita(),
                request.stato()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(salvato));
    }

    // Converte Entity in Response DTO
    private OrdineResponse toResponse(Ordine ordine) {
        return new OrdineResponse(
                ordine.getId(),
                ordine.getUtente().getId(),
                ordine.getProdotto().getId(),
                ordine.getQuantita(),
                ordine.getDataOrdine(),
                ordine.getStato()
        );
    }
}
// prova