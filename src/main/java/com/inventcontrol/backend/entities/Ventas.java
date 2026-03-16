package com.inventcontrol.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroFactura;
    @CreationTimestamp
    private LocalDateTime fecha;
    private BigDecimal total;
    private String estado;
    private String tipoPago;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<VentasDetalles> detalles;
}
