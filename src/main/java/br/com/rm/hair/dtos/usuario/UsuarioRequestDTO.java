package br.com.rm.hair.dtos.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        java.util.UUID id,
        @NotBlank String name,
        @NotBlank String telefone,
        @NotBlank String email,
        @NotBlank String senha) {
}