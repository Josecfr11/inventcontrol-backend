package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.ClienteListDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteListDTO> findAll();
}
