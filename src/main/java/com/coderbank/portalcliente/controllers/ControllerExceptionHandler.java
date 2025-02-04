package com.coderbank.portalcliente.controllers;

import com.coderbank.portalcliente.exceptions.ClienteJaExistenteException;
import com.coderbank.portalcliente.exceptions.ClienteNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.util.HashMap;

@ControllerAdvice
public class ControllerExceptionHandler {

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

    //Exception que irá capturar exceptions de validações, a exceptions que captura as validoções
    //é a MethodArgumentNotValidException
    //exception que irá mostrar o campo que gerou o valor e a mensagem de erro

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleValidation (final MethodArgumentNotValidException exception){

        final var errors = new HashMap<>();

        metodoParaObterChaveValorDoErro(exception, errors);

        var problemDetail =  ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errors.toString());

        problemDetail.setTitle("Dados inválidos!");
        problemDetail.setType(URI.create("http://www.coderbank.com.br/fordevs/docs/errors/bad-request"));

        return problemDetail;
    }

    //metodo que retorna a chave que gerou o erro e o valor que é a mensagem de erro;
    private static void metodoParaObterChaveValorDoErro(MethodArgumentNotValidException exception, HashMap<Object, Object> errors) {

        exception.getBindingResult() //getBindingResult() retorna um objeto do tipo BindingResult, que contém todos os erros de validação detectados durante o processamento de uma requisição.
                .getAllErrors() //Esse método retorna uma lista de todos os erros (ObjectError) encontrados, cada erro pode representar um prblema geral de validação
                .forEach((error) ->{ //foreach percorre todos os erros, e para acessar cria uma function anoninma

                    var chave = ((FieldError)error).getField();

                    var valor = error.getDefaultMessage();

                    errors.put(chave, valor);
                });
    }

    @ExceptionHandler({ClienteNaoEncontrado.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail notFound(final Throwable throwable){

        var message = throwable.getMessage();

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);

        problemDetail.setTitle("Cliente não encontrado!");
        problemDetail.setType(URI.create("http://www.coderbank.com.br/fordevs/docs/errors/not-found"));

        return problemDetail;

    }
}
