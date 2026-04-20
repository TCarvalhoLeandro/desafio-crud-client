package com.example.leandro.crud_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leandro.crud_client.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
