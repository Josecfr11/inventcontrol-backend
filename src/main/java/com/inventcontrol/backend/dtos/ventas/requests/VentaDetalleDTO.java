package com.inventcontrol.backend.dtos.ventas.requests;

import java.math.BigDecimal;

public record VentaDetalleDTO(
        Long herramientaId,
        Integer cantidad,
        BigDecimal precioUnitario,
        BigDecimal subtotal
) {}