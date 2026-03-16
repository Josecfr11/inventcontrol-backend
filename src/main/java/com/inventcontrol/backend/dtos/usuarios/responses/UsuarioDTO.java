package com.inventcontrol.backend.dtos.usuarios.responses;

public record UsuarioDTO(
        Long id,
        String username,
        String email,
        String nombreCompleto,
        String rol,
        Boolean activo
) {}