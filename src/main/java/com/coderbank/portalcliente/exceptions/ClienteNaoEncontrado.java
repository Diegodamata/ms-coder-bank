package com.coderbank.portalcliente.exceptions;

public class ClienteNaoEncontrado extends RuntimeException{

    public ClienteNaoEncontrado(String msg){
        super(msg);
    }
}
