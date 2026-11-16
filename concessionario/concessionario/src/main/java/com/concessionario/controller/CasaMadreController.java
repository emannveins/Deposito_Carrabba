
package com.concessionario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionario.dto.CasaMadreResponseDTO;
import com.concessionario.entity.CasaMadre;
import com.concessionario.mapper.EntityDtoMapper;
import com.concessionario.service.CasaMadreService;

@RestController
@RequestMapping("/case-madri")
public class CasaMadreController {

    private final CasaMadreService casaMadreService;
    private final EntityDtoMapper mapper;

    public CasaMadreController(CasaMadreService casaMadreService,EntityDtoMapper mapper) {
        this.casaMadreService = casaMadreService;
        this.mapper = mapper;
    }
    
    @PostMapping
    public ResponseEntity<CasaMadreResponseDTO> create(@RequestBody CasaMadre casaMadre) {
        CasaMadre saved = casaMadreService.create(casaMadre);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toCasaMadreDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<CasaMadreResponseDTO>> findAll() {
        List<CasaMadreResponseDTO> response =
                casaMadreService.findAll()
                        .stream()
                        .map(mapper::toCasaMadreDTO)
                        .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaMadreResponseDTO> findById( @PathVariable Long id) {
        return ResponseEntity.ok(
                mapper.toCasaMadreDTO(
                        casaMadreService.findById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasaMadreResponseDTO> update( @PathVariable Long id,@RequestBody CasaMadre casaMadre) {
        CasaMadre updated = casaMadreService.update(id, casaMadre);
        return ResponseEntity.ok(
                mapper.toCasaMadreDTO(updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        casaMadreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
