package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByActivoTrue();
    Optional<Usuarios> findByUsername(String username);
}
