package com.inventcontrol.backend.dtos.usuarios.requests;
public record LoginRequestDTO(
        String username,
        String password
) {}