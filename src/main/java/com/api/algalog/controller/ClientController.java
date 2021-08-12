package com.api.algalog.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}