package com.inventcontrol.backend.mapper;
import com.inventcontrol.backend.dtos.movimientos.requests.MovimientoDTO;
import com.inventcontrol.backend.entities.Movimientos;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface MovimientosMapper {
    MovimientoDTO toDto(Movimientos entity);
    Movimientos toEntity(MovimientoDTO dto);
}
