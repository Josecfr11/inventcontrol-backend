package com.inventcontrol.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "herramientas")
public class Herramienta {
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
    private String fechaAdquisicion;
}
