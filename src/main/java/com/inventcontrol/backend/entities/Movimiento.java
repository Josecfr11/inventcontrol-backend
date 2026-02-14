package com.inventcontrol.backend.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Movimiento {
    private Long id;
    private String tipoMovimiento;
    private LocalDateTime fecha;
    private String moduloOrigen;
    private Integer cantidad;
    private String descripcion;

}
