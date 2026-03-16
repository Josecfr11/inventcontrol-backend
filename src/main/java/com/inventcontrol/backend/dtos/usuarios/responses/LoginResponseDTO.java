package com.inventcontrol.backend.dtos.usuarios.responses;

public record LoginResponseDTO(
        Long id,
        String username,
        String nombreCompleto,
        String rol
) {}