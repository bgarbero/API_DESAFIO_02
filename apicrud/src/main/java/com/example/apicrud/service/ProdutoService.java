package com.example.apicrud.service;

import java.util.Date;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apicrud.model.Produto;
import com.example.apicrud.model.exception.ResourceBadRequestException;
import com.example.apicrud.model.exception.ResourceNotFoundException;
import com.example.apicrud.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto){
        
        if(produto.getDataDeValidade().getTime() <= new Date().getTime()){
            throw new ResourceBadRequestException("A data de validade deve ser maior que a data atual.");
        }

        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){

        return produtoRepository.findAll();
    }

    public Produto obterPorId(Long id){
        
        Optional<Produto> optProduto = produtoRepository.findById(id);

        if(optProduto.isEmpty()){
            throw new ResourceNotFoundException("Não existe um produto com o ID " + id);
        }

        return optProduto.get();
    }

    public Produto atualizar(Long id, Produto produto){

        if(produto.getDataDeValidade().getTime() <= new Date().getTime()){
            throw new ResourceBadRequestException("A data de validade deve ser maior que a data atual.");
        }

        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
}
