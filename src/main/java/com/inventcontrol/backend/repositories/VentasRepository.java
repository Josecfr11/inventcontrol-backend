package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Venta, Long> {
}
