package com.coderbank.portalcliente.dtos.responses;

import com.coderbank.portalcliente.entities.Status;

import java.util.UUID;

public record ClienteResponseDto(
        UUID clienteID,
        Status status,
        String criadoDataEHora
) {
}
