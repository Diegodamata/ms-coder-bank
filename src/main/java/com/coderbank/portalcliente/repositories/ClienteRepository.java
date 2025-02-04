package com.coderbank.portalcliente.repositories;

import com.coderbank.portalcliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    boolean findByCpf(String cpfCliente);
}
