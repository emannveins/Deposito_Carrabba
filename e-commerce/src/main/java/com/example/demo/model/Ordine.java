package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "ordine")
public class Ordine {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer quantita;
    private LocalDateTime dataOrdine;
    private String stato;

    
    @ManyToOne // piu ordini possono appartenere allo stesso utente
    @JoinColumn(name = "utente_id") // indica la colonna che contiene la chiave esterna
      private Utente utente;

    @OneToOne // ogni ordine e asociato a un prodotto
    @JoinColumn (name= "prodotto_id")
    private Prodotto prodotto;

    public Ordine(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public LocalDateTime getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDateTime dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
    

}
