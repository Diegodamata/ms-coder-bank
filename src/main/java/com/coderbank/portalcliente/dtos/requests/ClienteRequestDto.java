package com.coderbank.portalcliente.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.xml.stream.XMLInputFactory;

public record ClienteRequestDto(

        @NotBlank(message = "O campo nome precisa ser preenchido")
        String name,

        @NotBlank(message = "O campo cpf precisa ser preenchido")
        @CPF
        String cpf,

        @NotBlank(message = "O campo email precisa ser preenchido")
        @Email
        String email,

        Integer idade,

        @NotBlank(message = "O campo endereco precisa ser preenchido")
        String endereco
) {
}
