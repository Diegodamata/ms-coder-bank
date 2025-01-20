package com.coderbank.portalcliente.services;

import com.coderbank.portalcliente.dtos.requests.ClienteRequestDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResponseDto;
import com.coderbank.portalcliente.dtos.responses.ClienteResumoResponseDto;
import com.coderbank.portalcliente.dtos.responses.PagedResponse;
import com.coderbank.portalcliente.entities.Cliente;
import com.coderbank.portalcliente.entities.Status;
import com.coderbank.portalcliente.exceptions.ClienteJaExistenteException;
import com.coderbank.portalcliente.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDto salvarCliente(final ClienteRequestDto clienteRequestDto){

        validarCpfCliente(clienteRequestDto);

        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequestDto, cliente);

        cliente.setStatus(Status.ATIVO);

        clienteRepository.save(cliente);

        return new ClienteResponseDto(cliente.getClienteId()
                  ,cliente.getStatus()
                  ,cliente.getCriadoDataEHora());
    }

    public void validarCpfCliente(final ClienteRequestDto clienteRequestDto){
        final var numeroCpf = clienteRequestDto.cpf();

        if(clienteRepository.findByCpf(numeroCpf)){
            throw new ClienteJaExistenteException("Cliente com o cpf: " + numeroCpf + ", já existente!");
        }
    }

    //vai me retornar as paginas de clienteResumoResponseDto
    public Page<ClienteResumoResponseDto> obterClientes(Pageable pageable){

        //tras para mim todos os clientes do banco
       return clienteRepository.findAll(pageable)
               .map(cliente -> new ClienteResumoResponseDto( //utilizando o map converti para clienteResumo
                       cliente.getClienteId(),
                       cliente.getName(),
                       cliente.getStatus()));
    }
}
