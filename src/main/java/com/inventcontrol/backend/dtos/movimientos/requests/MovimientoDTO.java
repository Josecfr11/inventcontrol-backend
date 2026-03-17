package com.inventcontrol.backend.dtos.movimientos.requests;

import java.time.LocalDateTime;

public record MovimientoDTO(
        Long id,
        String tipoMovimiento,
        LocalDateTime fecha,
        String moduloOrigen,
        Integer cantidad,
        String descripcion
) {}