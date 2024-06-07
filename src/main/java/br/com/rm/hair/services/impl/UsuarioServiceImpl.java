package br.com.rm.hair.services.impl;


import br.com.rm.hair.dtos.usuario.UsuarioRequestDTO;
import br.com.rm.hair.dtos.usuario.UsuarioResponseDTO;
import br.com.rm.hair.entities.UsuarioEntity;
import br.com.rm.hair.repositories.UsuarioRepository;
import br.com.rm.hair.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> findAll() {

        return null;
    }

    @Override
    public UsuarioResponseDTO findById(String id){
        var usuario = this.usuarioRepository.findById(UUID.fromString(id));
        if(usuario.isEmpty()){
        throw new RuntimeException("Usuario não localizado");
        }
        var usuarioEntidade = usuario.get();
        return new UsuarioResponseDTO(usuarioEntidade.getId(), usuarioEntidade.getName(), usuarioEntidade.getTelefone(), usuarioEntidade.getEmail());
    }

    @Override
    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioEntity usuarioEntidade = new UsuarioEntity(usuarioRequestDTO.name(), usuarioRequestDTO.telefone(), usuarioRequestDTO.email(), usuarioRequestDTO.senha());
        var usuario = this.usuarioRepository.save((usuarioEntidade));
        return new UsuarioResponseDTO(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getTelefone());
    }

    @Override
    //1° buscar usuario no bd, 2° atualizar os dados, 3° gravar de volta no banco.
    public UsuarioResponseDTO update(String id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioEntity> usuario = this.usuarioRepository.findById(UUID.fromString(id));
            if (usuario.isEmpty()) {
                throw new RuntimeException("Usuario nao localizado");
            }
            UsuarioEntity usuarioEntidade = usuario.get();
        return null;
    }
    //  Optional<ClienteEntity> cliente = this.clienteRepository.findById(UUID.fromString(id));
    //        if (cliente.isEmpty()) {
    //            throw new RuntimeException("Cliente não localizado.");
    //        }
    //        var clienteEntidade = cliente.get();
    //        clienteEntidade.update(clienteRequestDTO.name(), clienteRequestDTO.telefone(), clienteRequestDTO.email());
    //        var clienteAtualizado = clienteRepository.save(clienteEntidade);
    //        return new ClienteResponseDTO(clienteAtualizado);
    //    }

    @Override
    public void delete(String id) {

    }
}