package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {
    public List<ClienteListDTO> toDtoList(List<Clientes> clientes);
//    Cliente toEntity(ProductoDTO productoDTO)
    ClienteByIdDTO toByIdDTO(Clientes clientes);

    List<ClienteListDTO> toResponseList(List<Clientes> entities);
//    void updateEntity(UserRequestDTO dto, @MappingTarget User entity);
}
