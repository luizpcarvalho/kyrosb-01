package com.kyrosb01.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id){
        super("Não foi possível encontrar o cliente " + id);
    }

}
