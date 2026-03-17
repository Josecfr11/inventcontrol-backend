package com.inventcontrol.backend.dtos.compras.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CompraResponseDTO(
        Long id,
        String numeroOrden,
        LocalDateTime fechaRegistro,
        BigDecimal total,
        String estado,
        String observaciones,
        String proveedorNombre,
        List<CompraDetalleResponseDTO> detalles
) {}