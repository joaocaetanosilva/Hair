package br.com.rm.hair.services;

import br.com.rm.hair.dtos.cliente.ClienteRequestDTO;
import br.com.rm.hair.dtos.cliente.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO findById(String id);
    List<ClienteResponseDTO> findAll();
    //Não tenho que passar como parametro "UsuarioDTO usuarioDTo"?
    ClienteResponseDTO save(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO update(String id, ClienteRequestDTO clienteRequestDTO);
    //Pq não usei o ClienteDto?
    void delete(String id);
}
//Declaração de metodos?