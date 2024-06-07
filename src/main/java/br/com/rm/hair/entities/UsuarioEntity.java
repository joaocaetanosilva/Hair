package br.com.rm.hair.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUid = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    String telefone;
    String email;
    String senha;

    public UsuarioEntity(){
    }

    public UsuarioEntity(String name, String telefone, String email, String senha){
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
