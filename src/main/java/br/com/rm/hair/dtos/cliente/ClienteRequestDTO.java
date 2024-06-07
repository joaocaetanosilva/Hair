package br.com.rm.hair.dtos.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
        java.util.UUID id,
        @NotBlank String name,
        @NotBlank String telefone,
        @NotBlank String email) {
}
//Carrega esse dados para outros locais do projeto?
