package com.example.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apicrud.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
