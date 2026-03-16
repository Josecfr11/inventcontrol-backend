package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.dtos.proveedores.ProveedorDTO;
import com.inventcontrol.backend.entities.Proveedores;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    Proveedores toEntity(ProveedorDTO dto);
    ProveedorDTO toDto(Proveedores entity);
}