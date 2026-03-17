package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.movimientos.requests.MovimientoDTO;
import com.inventcontrol.backend.mapper.MovimientosMapper;
import com.inventcontrol.backend.repositories.MovimientosRepository;
import com.inventcontrol.backend.services.IMovimientosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovimientosServiceImpl implements IMovimientosService {
    private final MovimientosRepository repository;
    private final MovimientosMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoDTO> findAll() {
        return repository.findAllByOrderByFechaDesc().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
