package com.inventcontrol.backend.dtos.compras.requests;

import java.math.BigDecimal;

public record CompraDetalleRequestDTO(
        Long herramientaId,
        Integer cantidad,
        BigDecimal precioUnitarioCompra,
        BigDecimal subtotal,
        Integer numSerie
) {}
