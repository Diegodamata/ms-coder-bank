package com.coderbank.portalcliente.controllers;

import com.coderbank.portalcliente.dtos.requests.ClienteRequestDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResponseDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResumoResponseDto;
import com.coderbank.portalcliente.dtos.responses.PagedResponse;
import com.coderbank.portalcliente.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> salvarCliente(@RequestBody @Valid ClienteRequestDto clienteRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.salvarCliente(clienteRequestDto));
    }

    //retornar os clientes paginados
    @GetMapping
    public PagedResponse<ClienteResumoResponseDto> obterClientes(
            @RequestParam(defaultValue = "0") int pagina, //preciso passar o valor da pagina que eu quero assessar
            @RequestParam(defaultValue = "10") int tamanho //e o tamanho de conteudo por pagina ex(10 clientes por página)
    ){

        //recebendo uma instancia da classe PageRequest pegando as paginas e o conteudo
        var pageable = PageRequest.of(pagina, tamanho);

        var paginaClientes = clienteService.obterClientes(pageable);

        return new PagedResponse<>(paginaClientes);
    }
}
