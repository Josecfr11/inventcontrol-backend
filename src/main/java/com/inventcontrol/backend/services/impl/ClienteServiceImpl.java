package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.ClienteListDTO;
import com.inventcontrol.backend.entities.Cliente;
import com.inventcontrol.backend.mapper.ClienteMapper;
import com.inventcontrol.backend.repositories.ClienteRepository;
import com.inventcontrol.backend.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteListDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }
}
