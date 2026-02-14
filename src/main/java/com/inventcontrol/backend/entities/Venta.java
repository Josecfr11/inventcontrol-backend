package com.inventcontrol.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ventas")
public class Venta {
    private Long id;
    private String numeroFactura;
    @CreationTimestamp
    private LocalDateTime fecha;
    private Integer total;
    private String estado;
    private String tipoPago;
}
