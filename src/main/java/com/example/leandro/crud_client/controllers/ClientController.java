package com.example.leandro.crud_client.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leandro.crud_client.dto.ClientDTO;
import com.example.leandro.crud_client.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping(value = "/{id}")
	public ClientDTO findById(@PathVariable Long id) {
		ClientDTO dto =  clientService.findById(id);
		return dto;
	}
	
	@GetMapping
	public List<ClientDTO> findAll(){
		List<ClientDTO> list = clientService.findAll();
		return list;
	}
	
	@PostMapping
	public ClientDTO insert(@RequestBody ClientDTO dto) {
		dto = clientService.insert(dto);
		return dto;
	}
	
	@PutMapping(value = "/{id}")
	public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		return clientService.update(id, dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		clientService.delete(id);
	}
}
