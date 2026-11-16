package com.concessionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionario.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByConcessionario_Id(Long concessionarioId);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}