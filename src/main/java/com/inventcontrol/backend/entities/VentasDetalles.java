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
public class VentasDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Ventas venta; // La venta a la que pertenece este detalle

    @ManyToOne
    @JoinColumn(name = "herramienta_id")
    private Herramientas herramienta; // La herramienta vendida

    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}