package com.concessionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionario.entity.Concessionario;

public interface ConcessionarioRepository  extends JpaRepository<Concessionario, Long> {
    boolean existsByCasaMadre_Id(Long casaMadreId);
}