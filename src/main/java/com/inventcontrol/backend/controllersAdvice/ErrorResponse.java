package com.inventcontrol.backend.controllersAdvice;

public record ErrorResponse(
        String campo,
        String mensaje
) {}