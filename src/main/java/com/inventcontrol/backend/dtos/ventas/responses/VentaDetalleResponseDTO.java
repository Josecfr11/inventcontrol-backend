package com.inventcontrol.backend.dtos.ventas.responses;

import java.math.BigDecimal;

public record VentaDetalleResponseDTO(
        Long herramientaId,
        String herramientaNombre,
        Integer cantidad,
        BigDecimal precioUnitario,
        BigDecimal subtotal
) {}