package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compra, Long> {
}
