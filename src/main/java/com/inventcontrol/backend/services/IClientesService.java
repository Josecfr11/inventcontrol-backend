package com.inventcontrol.backend.services;

import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteUpdateDTO;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteNewDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteListDTO;

import java.util.List;

public interface IClientesService {
    List<ClienteListDTO> findAll();
    ClienteByIdDTO findById(Long id);
    Clientes save(ClienteNewDTO clienteNewDTO);
    void updateCliente(Long id, ClienteUpdateDTO clienteUpdateDTO);
    void delete(Long id);
}
