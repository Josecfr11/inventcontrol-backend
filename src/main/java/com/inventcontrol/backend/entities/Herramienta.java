package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "herramientas")
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String ubicacion;
    private String estado;
    private Integer stock_min;
    private Integer stock_actual;
    private Integer valor;
    private String imagen;
    @CreationTimestamp
    private LocalDateTime fechaAdquisicion;
}
