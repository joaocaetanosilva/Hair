package br.com.rm.hair.dtos.usuario;

import br.com.rm.hair.entities.UsuarioEntity;
import jakarta.validation.constraints.NotBlank;

public record UsuarioResponseDTO(
        java.util.UUID id,
        @NotBlank String name,
        @NotBlank String telefone,
        @NotBlank String email) {
}