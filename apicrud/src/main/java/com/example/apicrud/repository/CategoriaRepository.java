package com.example.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apicrud.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
