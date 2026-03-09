package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
