package com.inventcontrol.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroFactura;
    @CreationTimestamp
    private LocalDateTime fecha;
    private Integer total;
    private String estado;
    private String tipoPago;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;
}
