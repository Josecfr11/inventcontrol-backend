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
public class Compra {
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
    private Proveedor proveedor;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<CompraDetalle> compraDetalles;
}
