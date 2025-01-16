package com.coderbank.portalcliente.exceptions;

public class ClienteJaExistenteException extends RuntimeException{

    public ClienteJaExistenteException(String msg){
        super(msg);
    }
}
