
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

import com.concessionario.dto.ClienteResponseDTO;
import com.concessionario.entity.Cliente;
import com.concessionario.entity.Concessionario;
import com.concessionario.mapper.EntityDtoMapper;
import com.concessionario.service.ClienteService;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

    private final ClienteService clienteService;
    private final EntityDtoMapper mapper;

    public ClienteController(ClienteService clienteService, EntityDtoMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody Cliente cliente,@RequestParam Long concessionarioId) {
        Concessionario concessionario = new Concessionario();
        concessionario.setId(concessionarioId);
        cliente.setConcessionario(concessionario);
        Cliente saved = clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toClienteDTO(saved));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        List<ClienteResponseDTO> response =
                clienteService.findAll()
                        .stream()
                        .map(mapper::toClienteDTO)
                        .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                mapper.toClienteDTO(
                        clienteService.findById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update( @PathVariable Long id, @RequestBody Cliente cliente,@RequestParam Long concessionarioId) {
        Concessionario concessionario = new Concessionario();
        concessionario.setId(concessionarioId);
        cliente.setConcessionario(concessionario);
        Cliente updated = clienteService.update(id, cliente);
        return ResponseEntity.ok(
                mapper.toClienteDTO(updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
