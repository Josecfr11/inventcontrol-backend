package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.movimientos.requests.MovimientoDTO;

import java.util.List;

public interface IMovimientosService {
    List<MovimientoDTO> findAll();
}