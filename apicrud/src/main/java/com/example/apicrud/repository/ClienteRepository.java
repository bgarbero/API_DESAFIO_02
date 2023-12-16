package com.example.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apicrud.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
