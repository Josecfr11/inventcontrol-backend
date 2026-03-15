package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "herramientas")
@Data
public class Herramientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String ubicacion;
    private String estado;
    private Integer stockMin;
    private Integer stockActual;
    private BigDecimal valor;
    private String imagen;
    @CreationTimestamp
    private LocalDateTime fechaAdquisicion;
    @Column(columnDefinition = "boolean default true")
    private Boolean activo = true;
}
