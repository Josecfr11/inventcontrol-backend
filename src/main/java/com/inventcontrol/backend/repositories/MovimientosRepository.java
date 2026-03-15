package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
}
