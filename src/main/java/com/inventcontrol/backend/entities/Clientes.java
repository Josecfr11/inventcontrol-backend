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
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String tipo;
    private String direccion;
    private Boolean activo;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Ventas> ventas;
}
