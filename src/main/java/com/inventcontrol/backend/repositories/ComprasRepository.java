package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
