
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concessionario.dto.ConcessionarioResponseDTO;
import com.concessionario.entity.CasaMadre;
import com.concessionario.entity.Concessionario;
import com.concessionario.mapper.EntityDtoMapper;
import com.concessionario.service.ConcessionarioService;

@RestController
@RequestMapping("/concessionari")
public class ConcessionarioController {

    private final ConcessionarioService concessionarioService;
    private final EntityDtoMapper mapper;

    public ConcessionarioController(ConcessionarioService concessionarioService,EntityDtoMapper mapper) {
        this.concessionarioService = concessionarioService;
        this.mapper = mapper;
    }

    @PostMapping("/new")
    public ResponseEntity<ConcessionarioResponseDTO> create(@RequestBody Concessionario concessionario,@RequestParam Long casaMadreId) {
        CasaMadre casaMadre = new CasaMadre();
        casaMadre.setId(casaMadreId);
        concessionario.setCasaMadre(casaMadre);
        Concessionario saved = concessionarioService.create(concessionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toConcessionarioDTO(saved));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConcessionarioResponseDTO>> findAll() {
        List<ConcessionarioResponseDTO> response =
                concessionarioService.findAll()
                        .stream()
                        .map(mapper::toConcessionarioDTO)
                        .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{find-id}")
    public ResponseEntity<ConcessionarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                mapper.toConcessionarioDTO(
                        concessionarioService.findById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionarioResponseDTO> update(
            @PathVariable Long id,
            @RequestBody Concessionario concessionario,
            @RequestParam Long casaMadreId) {
        CasaMadre casaMadre = new CasaMadre();
        casaMadre.setId(casaMadreId);
        concessionario.setCasaMadre(casaMadre);

        Concessionario updated = concessionarioService.update(id, concessionario);
        return ResponseEntity.ok(
                mapper.toConcessionarioDTO(updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        concessionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
