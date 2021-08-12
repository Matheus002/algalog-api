package com.api.algalog.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.algalog.domain.model.Client;
import com.api.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientRepository clientRepository;

    @GetMapping
    public List<Client> listar() {
       return clientRepository.findAll();
    }
    
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
    	return clientRepository.findById(clientId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());

    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
    	return clientRepository.save(client);
    }
    
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client){
    	if (!clientRepository.existsById(clientId)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	client.setId(clientId);
    	client = clientRepository.save(client);
    	
    	return ResponseEntity.ok(client);
    }
}