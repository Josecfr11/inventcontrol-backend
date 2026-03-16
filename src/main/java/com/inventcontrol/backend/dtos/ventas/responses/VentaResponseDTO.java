package com.inventcontrol.backend.dtos.ventas.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VentaResponseDTO(
        Long id,
        String numeroFactura,
        String estado,
        String tipoPago,
        BigDecimal total,
        LocalDateTime fecha,
        String clienteNombre,
        List<VentaDetalleResponseDTO> detalles
) {}