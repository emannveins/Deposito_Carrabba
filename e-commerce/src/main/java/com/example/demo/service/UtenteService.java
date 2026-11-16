package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;


@Service 
public class UtenteService {    
   private final UtenteRepository utenteRepository;

   // iniezione di dipendenze tramite costruttore
   public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
   }


   // METODO 1
   public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
   }
   // METODO 2
   public Optional<Utente> getUtenteById(Long id){
        return utenteRepository.findById(id);
   }
   // METODO 3
   public Utente creaUtente(Utente utente){
        return utenteRepository.save(utente);
   }

}
