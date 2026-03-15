package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.clientes.requests.ClienteListDTO;

import java.util.List;

public interface IClientesService {
    List<ClienteListDTO> findAll();
}
