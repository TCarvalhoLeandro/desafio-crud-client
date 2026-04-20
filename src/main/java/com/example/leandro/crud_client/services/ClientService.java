package com.example.leandro.crud_client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.leandro.crud_client.dto.ClientDTO;
import com.example.leandro.crud_client.entities.Client;
import com.example.leandro.crud_client.repositories.ClientRepository;
import com.example.leandro.crud_client.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> result = clientRepository.findAll();
		return result.stream().map(x -> new ClientDTO(x)).toList();
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		// cria um novo client
		Client client = new Client();
		// seta o client com os dados do dto que veio
		copyDtoToClient(dto, client);
		// salva no banco
		client = clientRepository.save(client);
		// retorna o client convertido para dto
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {

			Client client = clientRepository.getReferenceById(id);
			copyDtoToClient(dto, client);
			client = clientRepository.save(client);
			return new ClientDTO(client);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found.");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!clientRepository.existsById(id)) {
			throw new ResourceNotFoundException("Resource not found.");
		}
		clientRepository.deleteById(id);
	}
	
	// dto -> client
	public void copyDtoToClient(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
		
}
