package br.com.rm.hair.services;

import br.com.rm.hair.dtos.usuario.UsuarioRequestDTO;
import br.com.rm.hair.dtos.usuario.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> findAll();
    UsuarioResponseDTO findById(String id);
    UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO update(String id, UsuarioRequestDTO usuarioRequestDTO);
    void delete(String id);
}