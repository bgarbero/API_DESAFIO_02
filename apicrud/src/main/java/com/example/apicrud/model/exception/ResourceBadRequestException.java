package com.example.apicrud.model.exception;

public class ResourceBadRequestException extends RuntimeException{
    
    public ResourceBadRequestException (String mensagem){
        super(mensagem);
    }
}
