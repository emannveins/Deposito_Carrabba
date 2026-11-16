package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {


}
