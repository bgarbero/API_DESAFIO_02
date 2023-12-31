package com.example.apicrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apicrud.model.Categoria;
import com.example.apicrud.model.exception.ResourceNotFoundException;
import com.example.apicrud.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        
        return categoriaRepository.findAll();
    }

    public Categoria obterPorId(Long id){

        Optional<Categoria> optCategoria = categoriaRepository.findById(id); 

        if(optCategoria.isEmpty()){
            throw new ResourceNotFoundException("Não existe uma categoria com o ID " + id);
        }

        return optCategoria.get();
    }

    public Categoria atualizar(Long id, Categoria categoria){

        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}
