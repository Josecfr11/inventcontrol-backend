package com.inventcontrol.backend.dtos.herramientas.requests;

import java.math.BigDecimal;

public record HerramientasDTO(
        Long id,
        String codigo,
        String nombre,
        String descripcion,
        String categoria,
        String ubicacion,
        String estado,
        Integer stockMin,
        Integer stockActual,
        BigDecimal valor
) {}