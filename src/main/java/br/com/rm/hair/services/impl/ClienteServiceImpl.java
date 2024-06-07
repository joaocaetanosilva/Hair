package br.com.rm.hair.services.impl;

import br.com.rm.hair.dtos.cliente.ClienteResponseDTO;
import br.com.rm.hair.entities.ClienteEntity;
import br.com.rm.hair.dtos.cliente.ClienteRequestDTO;
import br.com.rm.hair.repositories.ClienteRepository;
import br.com.rm.hair.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDTO findById(String id) {
        var cliente = this.clienteRepository.findById(UUID.fromString(id));
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente nao localizado.");
        }
        var clienteEntidade = cliente.get();
        return new ClienteResponseDTO(clienteEntidade);
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        var clientes = this.clienteRepository.findAll();
        if (clientes.isEmpty()) {
            throw new RuntimeException("Clientes não localizados.");
        }
        ///parei aqui
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        clientes.forEach(e -> listaDeClientes.add(new ClienteResponseDTO(e)));
        return listaDeClientes;
    }

    @Override
    public ClienteResponseDTO save(ClienteRequestDTO clienteRequestDTO) {
        ClienteEntity clienteEntidade = new ClienteEntity(clienteRequestDTO.name(), clienteRequestDTO.telefone(), clienteRequestDTO.email());
        var cliente = this.clienteRepository.save(clienteEntidade);
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO update(String id, ClienteRequestDTO clienteRequestDTO) {
        Optional<ClienteEntity> cliente = this.clienteRepository.findById(UUID.fromString(id));
        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não localizado.");
        }
        var clienteEntidade = cliente.get();
        clienteEntidade.update(clienteRequestDTO.name(), clienteRequestDTO.telefone(), clienteRequestDTO.email());
        var clienteAtualizado = clienteRepository.save(clienteEntidade);
        return new ClienteResponseDTO(clienteAtualizado);
    }

    @Override
    public void delete(String id) {
        try {
            clienteRepository.deleteById(UUID.fromString(id));
        } catch (Exception e) {
            throw e;
        }
    }
}
