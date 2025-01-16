package com.coderbank.portalcliente.controllers;

import com.coderbank.portalcliente.exceptions.ClienteJaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class ClienteExceptionHandler {

    //Exception handler que ira capturar conflitos de existem cpfs existentes

    @ExceptionHandler({ClienteJaExistenteException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ProblemDetail conflict(final Throwable throwable){

        final var exceptionMessage = throwable.getMessage();

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exceptionMessage);

        problemDetail.setTitle("conflict"); //titulo do erro
        problemDetail.setType(URI.create("http://www.coderbank.com.br/fordevs/docs/errors/conflict")); //joga para um link que explica o motivo de ter dado o erro

        return problemDetail;
    }

}
