package br.com.rm.hair.repositories;

import br.com.rm.hair.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
}
//ClienteRepository pega os dados de ClienteEntity e envia por meio da JpaRepository para o banco gravar?
