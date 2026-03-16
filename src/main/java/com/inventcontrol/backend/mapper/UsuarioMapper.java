package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.dtos.usuarios.responses.UsuarioDTO;
import com.inventcontrol.backend.entities.Usuarios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDto(Usuarios entity);
}