package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas, Long> {
}
