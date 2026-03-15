package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroOrden;
    @CreationTimestamp
    private LocalDateTime fechaRegistro;
    private Integer total;
    private String estado;
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedores proveedor;
    @OneToMany(mappedBy = "compras", cascade = CascadeType.ALL)
    private List<ComprasDetalles> comprasDetalles;
}
