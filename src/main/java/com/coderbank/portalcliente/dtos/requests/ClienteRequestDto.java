package com.coderbank.portalcliente.dtos.requests;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;


public record ClienteRequestDto(

        String name,

        String cpf,

        String email,

        Integer idade,

        String endereco
) {
}
