package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.compras.requests.CompraRequestDTO;
import com.inventcontrol.backend.dtos.compras.responses.CompraResponseDTO;

import java.util.List;

public interface IComprasService {
    CompraResponseDTO create(CompraRequestDTO dto);
    List<CompraResponseDTO> findAll();
}
