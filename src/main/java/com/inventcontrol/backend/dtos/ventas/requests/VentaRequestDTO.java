package com.inventcontrol.backend.dtos.ventas.requests;

import java.math.BigDecimal;
import java.util.List;

public record VentaRequestDTO(
        String numeroFactura,
        String estado,
        String tipoPago,
        BigDecimal total,
        Long clienteId,
        List<VentaDetalleDTO> detalles
) {}