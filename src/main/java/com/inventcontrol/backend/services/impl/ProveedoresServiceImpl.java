package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.proveedores.ProveedorDTO;
import com.inventcontrol.backend.entities.Proveedores;
import com.inventcontrol.backend.mapper.ProveedorMapper;
import com.inventcontrol.backend.repositories.IProveedoresRepository;
import com.inventcontrol.backend.services.IProveedoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProveedoresServiceImpl implements IProveedoresService {

    private final IProveedoresRepository repository;
    private final ProveedorMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorDTO> findAll() {
        return repository.findByActivoTrue().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProveedorDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    @Transactional
    public ProveedorDTO save(ProveedorDTO dto) {
        Proveedores proveedor = mapper.toEntity(dto);
        proveedor.setActivo(true); // Siempre activo al crearse
        return mapper.toDto(repository.save(proveedor));
    }

    @Override
    @Transactional
    public ProveedorDTO update(Long id, ProveedorDTO dto) {
        Proveedores existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        existente.setNombre(dto.nombre());
        existente.setContacto(dto.contacto());
        existente.setTelefono(dto.telefono());
        existente.setEmail(dto.email());
        existente.setDireccion(dto.direccion());
        existente.setTipoProducto(dto.tipoProducto());

        return mapper.toDto(repository.save(existente));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Proveedores existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        existente.setActivo(false); // Borrado Lógico
        repository.save(existente);
    }
}