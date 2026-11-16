
package com.example.demo.dto;

public record ProdottoRequest(
    String nome,
    String descrizione,
    boolean disponibile
) {
}