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
@Table(name = "compras")
public class Compra {
    private Long id;
    private String numeroOrden;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;
    private Integer total;
    private String estado;
    private String observaciones;
}
