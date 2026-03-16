package com.inventcontrol.backend.dtos.usuarios.requests;

public record UsuarioNewDTO(
        String username,
        String email,
        String nombreCompleto,
        String rol,
        String password // Aquí recibimos la clave
) {}