package com.inventcontrol.backend.dtos.compras.responses;

import java.math.BigDecimal;

public record CompraDetalleResponseDTO(
        Long herramientaId,
        String herramientaNombre,
        Integer cantidad,
        BigDecimal precioUnitarioCompra,
        BigDecimal subtotal,
        Integer numSerie
) {}