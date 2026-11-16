package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // dice a jpa che questa classe rapprensenta un'entita persistente 
@Table(name = "utente") // nome tabella sql
public class Utente {

    @Id // chiave primaria entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategia affidata al db
    private Long id;

    private String nome;
    private String cognome;
    private String email;

    // relazione tra ordini
    @OneToMany(mappedBy = "utente") // un utente puo essere associato a piu ordini
    private final List<Ordine> ordini = new ArrayList<>();

    public Utente() { // costruttore vuoto per jpa
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }
}