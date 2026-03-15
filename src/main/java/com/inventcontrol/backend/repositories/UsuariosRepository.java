package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
