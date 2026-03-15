package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.dtos.herramientas.requests.HerramientasDTO;
import com.inventcontrol.backend.entities.Herramientas;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface HerramientasMapper {

    Herramientas toEntity(HerramientasDTO dto);
    HerramientasDTO toDto(Herramientas entidad);

}