package com.example.apicrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicrud.model.Categoria;
import com.example.apicrud.service.CategoriaService;

@RestController
@RequestMapping("/apicrud/categorias") //rota ou endpoint
@CrossOrigin("*")
public class categoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obterTodos(){
        return categoriaService.obterTodos();
    }

    @GetMapping("/{id}")
    public Categoria obterPorId(@PathVariable Long id){
        return categoriaService.obterPorId(id);
    }

    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria){
        return categoriaService.adicionar(categoria);
    }
}
