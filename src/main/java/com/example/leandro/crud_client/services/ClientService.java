package com.example.leandro.crud_client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leandro.crud_client.dto.ClientDTO;
import com.example.leandro.crud_client.entities.Client;
import com.example.leandro.crud_client.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	
	public Client findById(Long id) {
		return null;
	}
	
	
	public List<Client> findAll(){
		return null;
	}
	
	public void insert(ClientDTO entity) {
		
	}
	
	public void update(Long id, ClientDTO dto) {
		
	}
	
	public void delete(Long id) {
		
	}
	
	
}
