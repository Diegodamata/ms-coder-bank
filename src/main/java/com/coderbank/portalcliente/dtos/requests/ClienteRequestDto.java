package com.coderbank.portalcliente.dtos.requests;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;


public record ClienteRequestDto(

        @NotBlank(message = "O campo nome precisa ser preenchido")
        @Size(message = "O campo nome deve conter no mínimo 3 caracteres", min = 3)
        String name,

        @NotBlank(message = "O campo cpf precisa ser preenchido")
        @CPF(message = "CPF inválido")
        String cpf,

        @NotBlank(message = "O campo email precisa ser preenchido")
        @Email(message = "Email inválido")
        String email,

        @Min(message = "Idade mínima 16 anos", value = 16) @Max(message = "Idade máxima 120 anos", value = 120)
        Integer idade,

        @NotBlank(message = "O campo endereço precisa ser preenchido")
        String endereco
) {
}
