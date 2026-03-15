package com.inventcontrol.backend.mapper;

import com.inventcontrol.backend.dtos.clientes.requests.ClienteListDTO;
import com.inventcontrol.backend.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    public List<ClienteListDTO> toDtoList(List<Cliente> clientes);
//    Cliente toEntity(ProductoDTO productoDTO);
//    ProductoDTO toDto(Producto producto);
}
