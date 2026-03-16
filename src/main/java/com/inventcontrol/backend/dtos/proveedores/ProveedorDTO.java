package com.inventcontrol.backend.dtos.proveedores;

public record ProveedorDTO(
        Long id,
        String nombre,
        String contacto,
        String telefono,
        String email,
        String direccion,
        String tipoProducto,
        Boolean activo
) {}