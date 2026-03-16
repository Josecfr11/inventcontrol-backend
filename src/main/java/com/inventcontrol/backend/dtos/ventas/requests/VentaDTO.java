package com.inventcontrol.backend.dtos.ventas.requests;

import java.math.BigDecimal;
import java.util.List;

public record VentaDTO(
        String numeroFactura,
        String estado,
        String tipoPago,
        Long clienteId,
        BigDecimal total,
        List<VentaDetalleDTO> detalles // Recibe el FormArray de Angular
) {}