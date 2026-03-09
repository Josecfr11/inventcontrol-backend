package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;
    private String tipoProducto;
    private Boolean activo;
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Compra> compras;

}
