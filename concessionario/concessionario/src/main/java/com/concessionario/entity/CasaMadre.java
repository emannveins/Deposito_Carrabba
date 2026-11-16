package com.concessionario.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CASA_MADRE")

public class CasaMadre {
    @Column(name = "ragione_sociale", nullable = false, length = 100)
    private String ragioneSociale;

    @Column(name = "sede_legale", nullable = false, length = 100)
    private String sedeLegale;

    @Column(name = "paese", nullable = false, length = 50)
    private String paese;

    @Column(name = "anno_fondazione")
    private Integer annoFondazione;

    @Column(name = "fatturato_annuo", precision = 15, scale = 2)
    private BigDecimal fatturatoAnnuo;

    // relazione con concessionario
    @OneToMany(mappedBy = "casaMadre", fetch = FetchType.LAZY)
    @JsonManagedReference("casa-madre-concessionari")
    private List<Concessionario> concessionari = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public Integer getAnnoFondazione() {
        return annoFondazione;
    }

    public void setAnnoFondazione(Integer annoFondazione) {
        this.annoFondazione = annoFondazione;
    }

    public BigDecimal getFatturatoAnnuo() {
        return fatturatoAnnuo;
    }

    public void setFatturatoAnnuo(BigDecimal fatturatoAnnuo) {
        this.fatturatoAnnuo = fatturatoAnnuo;
    }

    public List<Concessionario> getConcessionari() {
        return concessionari;
    }

    public void setConcessionari(List<Concessionario> concessionari) {
        this.concessionari = concessionari;
    }

}