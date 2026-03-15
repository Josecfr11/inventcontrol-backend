package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
