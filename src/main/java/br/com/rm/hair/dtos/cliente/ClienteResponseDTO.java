package br.com.rm.hair.dtos.cliente;

import br.com.rm.hair.entities.ClienteEntity;
import jakarta.validation.constraints.NotBlank;

public record ClienteResponseDTO(
        java.util.UUID id,
        @NotBlank String name,
        @NotBlank String telefone,
        @NotBlank String email) {

    public ClienteResponseDTO(ClienteEntity clienteEntity){
        this(clienteEntity.getId(), clienteEntity.getName(), clienteEntity.getTelefone(), clienteEntity.getEmail());
    }
}
//Carrega esse dados para outros locais do projeto?
