package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComprasDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compras compras;
    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramientas herramientas;
    private Integer cantidad;
    @Column(precision = 12, scale = 2)
    private BigDecimal precioUnitarioCompra;
    @Column(precision = 12, scale = 2)
    private BigDecimal subtotal;
    private Integer numSerie;
}
