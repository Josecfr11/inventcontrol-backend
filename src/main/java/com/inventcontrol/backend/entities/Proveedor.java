package com.inventcontrol.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "proveedores")
public class Proveedor {
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;
    private String tipoProducto;
    private Boolean activo;
}
