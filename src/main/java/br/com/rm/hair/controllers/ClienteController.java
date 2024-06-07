package br.com.rm.hair.controllers;

import br.com.rm.hair.dtos.cliente.ClienteRequestDTO;
import br.com.rm.hair.dtos.cliente.ClienteResponseDTO;
import br.com.rm.hair.services.ClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    //Pq essa linha?

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable String id){

        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.save(clienteRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO, @PathVariable String id){
        return ResponseEntity.ok(clienteService.update(id, clienteRequestDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        clienteService.delete(id);
    }
    //Vai deletar só o id?
}
