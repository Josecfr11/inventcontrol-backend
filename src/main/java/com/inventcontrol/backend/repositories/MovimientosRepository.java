package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimiento, Long> {
}
