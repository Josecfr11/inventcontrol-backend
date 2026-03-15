package com.inventcontrol.backend.services;

import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteListDTO;

import java.util.List;

public interface IClientesService {
    List<ClienteListDTO> findAll();
    ClienteByIdDTO findById(Long id);
}
