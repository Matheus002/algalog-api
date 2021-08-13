package com.api.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.algalog.domain.model.Client;
import com.api.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogClientService {
	
	private ClientRepository clientRepository;
	
	@Transactional
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	@Transactional
	public void deleteClient(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
