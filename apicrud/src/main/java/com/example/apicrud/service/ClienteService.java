package com.example.apicrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apicrud.model.Cliente;
import com.example.apicrud.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente){
        
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos(){
        
        return clienteRepository.findAll();
    }

    public Cliente obterPorId(Long id){
        Optional<Cliente> optCliente = clienteRepository.findById(id);

        if(optCliente.isEmpty()){
            throw new IllegalArgumentException("Não existe uma categoria com o ID" + id);
        }

        return optCliente.get();
    }

    public Cliente atualizar(Long id, Cliente cliente){

        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){

        clienteRepository.deleteById(id);
    }
}
