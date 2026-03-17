package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
    List<Movimientos> findAllByOrderByFechaDesc();
}
