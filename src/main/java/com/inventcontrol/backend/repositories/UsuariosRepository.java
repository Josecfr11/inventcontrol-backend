package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
}
