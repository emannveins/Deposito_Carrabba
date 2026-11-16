
package com.concessionario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.concessionario.entity.Cliente;
import com.concessionario.entity.Concessionario;
import com.concessionario.repository.ClienteRepository;
import com.concessionario.repository.ConcessionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ConcessionarioRepository concessionarioRepository;

    public ClienteService( ClienteRepository clienteRepository, ConcessionarioRepository concessionarioRepository) {
        this.clienteRepository = clienteRepository;
        this.concessionarioRepository = concessionarioRepository;
    }

    public Cliente create(Cliente cliente) {
        validate(cliente);
        if (cliente.getEmail() != null && clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalStateException(
                "email gia utilitzzata"
            );
        }

        Concessionario concessionario = concessionarioRepository.findById(
                    cliente.getConcessionario().getId()
                ).orElseThrow(() ->
                    new EntityNotFoundException(
                        "concessionario non trovato"
                    )
                );
        cliente.setId(null);
        cliente.setConcessionario(concessionario);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() ->
                    new EntityNotFoundException(
                        "cliente non trovato: " + id
                    ));
    }

    public Cliente update(Long id, Cliente nuovoCliente) {

        validate(nuovoCliente);
        Cliente cliente = findById(id);
        if (nuovoCliente.getEmail() != null &&
                clienteRepository.existsByEmailAndIdNot(
                    nuovoCliente.getEmail(), id)) {

            throw new IllegalStateException(
                "Email già utilizzata da un altro cliente"
            );
        }

        Concessionario concessionario = concessionarioRepository.findById(
                    nuovoCliente.getConcessionario().getId()
                ).orElseThrow(() ->
                    new EntityNotFoundException(
                        "concessionario non trovato"
                    )
                );

        cliente.setNome(nuovoCliente.getNome());
        cliente.setCognome(nuovoCliente.getCognome());
        cliente.setEmail(nuovoCliente.getEmail());
        cliente.setTelefono(nuovoCliente.getTelefono());
        cliente.setConcessionario(concessionario);
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }

    private void validate(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "dati del cliente non sono obbligatori"
            );
        }

        if (cliente.getNome() == null ||  cliente.getNome().isBlank()) {
            throw new IllegalArgumentException(
                "nome cliente obbligatorio"
            );
        }

        if (cliente.getCognome() == null || cliente.getCognome().isBlank()) {
            throw new IllegalArgumentException(
                "Icognome cliente non obbligatorio"
            );
        }

        if (cliente.getConcessionario() == null ||cliente.getConcessionario().getId() == null) {
            throw new IllegalArgumentException(
                "concessionario obbligatorio"
            );
        }
    }
}


