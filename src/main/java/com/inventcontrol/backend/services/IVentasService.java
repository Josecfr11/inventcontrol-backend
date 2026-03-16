package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.ventas.requests.VentaRequestDTO;
import com.inventcontrol.backend.dtos.ventas.responses.VentaResponseDTO;

import java.util.List;

public interface IVentasService {

    VentaResponseDTO create(VentaRequestDTO dto);

    List<VentaResponseDTO> findAll();
}