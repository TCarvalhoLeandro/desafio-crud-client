package com.example.leandro.crud_client.dto;

import java.time.LocalDate;

import com.example.leandro.crud_client.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class ClientDTO {
	
	private Long id;
	
	@NotBlank(message = "Campo não pode ser vazio.")
	private String name;
	private String cpf;
	private Double income;
	
	@PastOrPresent(message = "Data nascimento inválida.")
	private LocalDate birthDate;
	
	@PositiveOrZero(message = "Valor inválido.")
	private Integer children;
	
	public ClientDTO() {
		
	}
	
	// Client to ClientDTO
	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.birthDate = client.getBirthDate();
		this.children = client.getChildren();
	}
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Double getIncome() {
		return income;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public Integer getChildren() {
		return children;
	}
}
