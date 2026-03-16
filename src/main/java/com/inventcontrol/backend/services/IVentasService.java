package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.ventas.requests.VentaDTO;
import com.inventcontrol.backend.entities.Ventas;

import java.util.List;

public interface IVentasService {
    Ventas create(VentaDTO dto);
    List<Ventas> findAll();
}
