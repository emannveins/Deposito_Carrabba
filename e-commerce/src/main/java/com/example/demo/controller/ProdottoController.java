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

import com.example.demo.dto.ProdottoRequest;
import com.example.demo.dto.ProdottoResponse;
import com.example.demo.model.Prodotto;
import com.example.demo.service.ProdottoService;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    private final ProdottoService prodottoService;

    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    // API 1: recupera tutti i prodotti
    @GetMapping
    public List<ProdottoResponse> getAllProdotti() {
        return prodottoService.getAllProdotti()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // API 2: recupera un prodotto tramite ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdottoResponse> getProdottoById(
            @PathVariable Long id) {

        return prodottoService.getProdottoById(id)
                .map(prodotto ->
                        ResponseEntity.ok(toResponse(prodotto)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // API 3: crea un prodotto
    @PostMapping
    public ResponseEntity<ProdottoResponse> creaProdotto(
            @RequestBody ProdottoRequest request) {

        Prodotto prodotto = new Prodotto();

        prodotto.setNome(request.nome());
        prodotto.setDescrizione(request.descrizione());
        prodotto.setDisponibile(request.disponibile());

        Prodotto salvato = prodottoService.creaProdotto(prodotto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(salvato));
    }

    // Converte Entity in Response DTO
    private ProdottoResponse toResponse(Prodotto prodotto) {
        return new ProdottoResponse(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getDescrizione(),
                prodotto.isDisponibile()
        );
    }
}