package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.proveedores.ProveedorDTO;
import java.util.List;

public interface IProveedoresService {
    List<ProveedorDTO> findAll();
    ProveedorDTO findById(Long id);
    ProveedorDTO save(ProveedorDTO dto);
    ProveedorDTO update(Long id, ProveedorDTO dto);
    void delete(Long id);
}