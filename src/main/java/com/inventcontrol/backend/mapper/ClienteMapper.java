package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteListDTO;
import com.inventcontrol.backend.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {
    public List<ClienteListDTO> toDtoList(List<Cliente> clientes);
//    Cliente toEntity(ProductoDTO productoDTO)
    ClienteByIdDTO toByIdDTO(Cliente cliente);

    List<ClienteListDTO> toResponseList(List<Cliente> entities);
//    void updateEntity(UserRequestDTO dto, @MappingTarget User entity);
}
