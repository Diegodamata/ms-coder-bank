package com.coderbank.portalcliente.dtos.responses;

import com.coderbank.portalcliente.entities.Status;

import java.util.UUID;

public record ClienteResumoResponseDto(
        UUID id,
        String name,
        Status status
) {
}
