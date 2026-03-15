package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.exceptions.ResourceNotFoundException;
import com.inventcontrol.backend.services.dtos.clientes.requests.ClienteNewDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteListDTO;
import com.inventcontrol.backend.mapper.ClienteMapper;
import com.inventcontrol.backend.repositories.ClientesRepository;
import com.inventcontrol.backend.services.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientesServiceImpl implements IClientesService {
    private final ClientesRepository clientesRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteListDTO> findAll() {
        List<Clientes> clientes = clientesRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }

    @Override
    public ClienteByIdDTO findById(Long id) {
        Clientes clientes = clientesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        return clienteMapper.toByIdDTO(clientes);
    }

    @Override
    @Transactional
    public Clientes save(ClienteNewDTO clienteNewDTO) {
        Clientes clienteNew = clienteMapper.toEntity(clienteNewDTO);
        return clientesRepository.save(clienteNew);
    }
}
