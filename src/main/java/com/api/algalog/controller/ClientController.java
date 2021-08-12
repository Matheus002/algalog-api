package com.api.algalog.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.algalog.domain.model.Client;
import com.api.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClientController {
	
	private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> listar() {
       return clientRepository.findAll();
    }
}