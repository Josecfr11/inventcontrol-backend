package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteUpdateDTO;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteNewDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {
    public List<ClienteListDTO> toDtoList(List<Clientes> clientes);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ventas", ignore = true)
    Clientes toEntity(ClienteNewDTO clienteNewDTO);
    ClienteByIdDTO toByIdDTO(Clientes clientes);

    List<ClienteListDTO> toResponseList(List<Clientes> entities);
    void updateEntityFromDto(ClienteUpdateDTO dto, @MappingTarget Clientes entity);
}
