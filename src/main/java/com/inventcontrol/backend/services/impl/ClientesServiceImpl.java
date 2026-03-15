package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.exceptions.ResourceNotFoundException;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.services.dtos.clientes.responses.ClienteListDTO;
import com.inventcontrol.backend.entities.Cliente;
import com.inventcontrol.backend.mapper.ClienteMapper;
import com.inventcontrol.backend.repositories.ClienteRepository;
import com.inventcontrol.backend.services.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientesServiceImpl implements IClientesService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteListDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }

    @Override
    public ClienteByIdDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        return clienteMapper.toByIdDTO(cliente);
    }
}
