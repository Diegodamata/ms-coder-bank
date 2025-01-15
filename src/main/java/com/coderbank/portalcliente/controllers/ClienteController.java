package com.coderbank.portalcliente.controllers;

import com.coderbank.portalcliente.dtos.requests.ClienteRequestDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResponseDto;
import com.coderbank.portalcliente.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
