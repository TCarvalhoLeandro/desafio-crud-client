package com.example.leandro.crud_client.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leandro.crud_client.dto.ClientDTO;
import com.example.leandro.crud_client.entities.Client;
import com.example.leandro.crud_client.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping(value = "/{id}")
	public Client findById(Long id) {
		return null;
	}
	
	@GetMapping
	public List<Client> findAll(){
		return null;
	}
	
	@PostMapping
	public void insert(ClientDTO entity) {
		
	}
	
	@PutMapping(value = "/{id}")
	public void update(Long id, ClientDTO dto) {
		
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(Long id) {
		
	}
}
