package com.example.leandro.crud_client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leandro.crud_client.dto.ClientDTO;
import com.example.leandro.crud_client.entities.Client;
import com.example.leandro.crud_client.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	
	public ClientDTO findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		ClientDTO dto = new ClientDTO(client.get());
		return dto;
	}
	
	public List<ClientDTO> findAll(){
		List<Client> result = clientRepository.findAll();
		return result.stream().map(x -> new ClientDTO(x)).toList();
	}
	
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
	
	public ClientDTO update(Long id, ClientDTO dto) {
		Client client = new Client(findById(id));
		copyDtoToClient(dto, client);
		client = clientRepository.save(client);
		return new ClientDTO(client);
	}
	
	public void delete(Long id) {
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
