package com.coderbank.portalcliente.services;

import com.coderbank.portalcliente.dtos.requests.ClienteRequestDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResponseDto;
import com.coderbank.portalcliente.entities.Cliente;
import com.coderbank.portalcliente.entities.Status;
import com.coderbank.portalcliente.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDto salvarCliente(final ClienteRequestDto clienteRequestDto){

        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDto, cliente);

        cliente.setStatus(Status.ATIVO);

        clienteRepository.save(cliente);

        return new ClienteResponseDto(cliente.getClienteId()
                  ,cliente.getStatus()
                  ,cliente.getCriadoDataEHora());
    }
}
