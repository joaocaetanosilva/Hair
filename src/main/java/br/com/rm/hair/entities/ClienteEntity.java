package br.com.rm.hair.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity implements Serializable {
    //Uid apenas nessa class?
    private static final long serialVersionUid = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String telefone;
    private String email;

    public ClienteEntity(){
    }

    public ClienteEntity(String name, String telefone, String email){
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }

    public void update(String name, String telefone, String email){
        this.name = name;
        this.telefone = telefone;
        this.email = email;
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
}
