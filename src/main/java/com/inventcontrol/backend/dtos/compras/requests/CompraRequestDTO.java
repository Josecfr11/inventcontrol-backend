package com.inventcontrol.backend.dtos.compras.requests;

import java.math.BigDecimal;
import java.util.List;

public record CompraRequestDTO(
        Long proveedorId,
        String numeroOrden,
        BigDecimal total,
        String estado,
        String observaciones,
        List<CompraDetalleRequestDTO> detalles
) {
}
