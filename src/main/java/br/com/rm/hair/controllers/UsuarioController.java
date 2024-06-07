package br.com.rm.hair.controllers;

import br.com.rm.hair.dtos.cliente.ClienteResponseDTO;
import br.com.rm.hair.dtos.usuario.UsuarioRequestDTO;
import br.com.rm.hair.dtos.usuario.UsuarioResponseDTO;
import br.com.rm.hair.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> save(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDto){
        return ResponseEntity.ok(usuarioService.save(usuarioRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO, @PathVariable String id){
        return ResponseEntity.ok(usuarioService.update(id, usuarioRequestDTO));
    }

   @DeleteMapping("/{id}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
    usuarioService.delete(id);
   }
}