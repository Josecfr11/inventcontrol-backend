package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
