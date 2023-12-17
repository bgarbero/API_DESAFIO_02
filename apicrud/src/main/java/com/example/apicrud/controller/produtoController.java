package com.example.apicrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicrud.model.Produto;
import com.example.apicrud.service.ProdutoService;

@RestController
@RequestMapping("/apicrud/produtos")
@CrossOrigin("*")
public class produtoController {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        public List<Produto> obtertodos(){
            return produtoService.obterTodos();
        }

        @GetMapping("/{id}")
        public Produto obterPorId(@PathVariable Long id){
            return produtoService.obterPorId(id);
        }

        @PostMapping
        public Produto adicionar(@RequestBody Produto produto){
            return produtoService.adicionar(produto);
        }

        @PutMapping("/{id}")
        public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
            return produtoService.atualizar(id, produto);
        }

        @DeleteMapping("/{id}")
        public void deletar(@PathVariable Long id){
            produtoService.deletar(id);
        }
}
