package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Prodotto;
import com.example.demo.repository.ProdottoRepository;


@Service 
public class ProdottoService {    
   private final ProdottoRepository prodottoRepository;

   // iniezione di dipendenze tramite costruttore
   public ProdottoService(ProdottoRepository prodottoRepository){
        this.prodottoRepository = prodottoRepository;
   }


   // METODO 1
   public List<Prodotto> getAllProdotti(){
        return prodottoRepository.findAll();
   }
   // METODO 2
   public Optional<Prodotto> getProdottoById(Long id){
        return prodottoRepository.findById(id);
   }
   // METODO 3
   public Prodotto creaProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
   }

}
