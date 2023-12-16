package com.example.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apicrud.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
