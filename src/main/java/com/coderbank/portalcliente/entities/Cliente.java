package com.coderbank.portalcliente.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTES")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID clienteId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false ,unique = true, length = 11)
    private String cpf;

    @Column
    private String email;

    @Column
    private Integer idade;

    @Column
    private String endereco;

    @Column
    private Status status;

    @Column
    @CreationTimestamp
    private String criadoDataEHora;

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCriadoDataEHora() {
        return criadoDataEHora;
    }

    public void setCriadoDataEHora(String criadoDataEHora) {
        this.criadoDataEHora = criadoDataEHora;
    }
}
