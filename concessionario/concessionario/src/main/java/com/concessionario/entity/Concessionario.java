package com.concessionario.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONCESSIONARIO")
public class Concessionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "citta", nullable = false, length = 100)
    private String citta;

    @Column(name = "indirizzo", length = 150)
    private String indirizzo;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "fatturato", precision = 15, scale = 2)
    private BigDecimal fatturato;

    // relazione con concessionario
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "casa_madre_id", nullable = false)
    @JsonBackReference("casa-madre-concessionari")
    private CasaMadre casaMadre;

    // relazione con cliente
    @OneToMany(mappedBy = "concessionario", fetch = FetchType.LAZY)
    @JsonManagedReference("concessionario-clienti")
    private List<Cliente> clienti = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getFatturato() {
        return fatturato;
    }

    public void setFatturato(BigDecimal fatturato) {
        this.fatturato = fatturato;
    }

    public CasaMadre getCasaMadre() {
        return casaMadre;
    }

    public void setCasaMadre(CasaMadre casaMadre) {
        this.casaMadre = casaMadre;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }
    
}