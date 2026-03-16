package com.inventcontrol.backend.repositories;

import com.inventcontrol.backend.entities.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProveedoresRepository extends JpaRepository<Proveedores, Long> {
    List<Proveedores> findByActivoTrue();
}