package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.herramientas.requests.HerramientasDTO;
import com.inventcontrol.backend.entities.Herramientas;
import com.inventcontrol.backend.mapper.HerramientasMapper;
import com.inventcontrol.backend.repositories.HerramientasRepository;
import com.inventcontrol.backend.services.IHerramientasService;
import com.inventcontrol.backend.services.fileStorage.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HerramientasServiceImpl implements IHerramientasService {

    private final HerramientasRepository herramientasRepository;
    private final FileStorageService fileStorageService;
    private final HerramientasMapper mapper;

    @Override
    @Transactional
    public Herramientas save(HerramientasDTO dto, MultipartFile file) {
        Herramientas herramienta = mapper.toEntity(dto);

        if (file != null && !file.isEmpty()) {
            String fileName = fileStorageService.storeFile(file);
            herramienta.setImagen(fileName);
        }
        return herramientasRepository.save(herramienta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Herramientas> findAll() {
        return herramientasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Herramientas findById(Long id) {
        return herramientasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + id));
    }
    @Override
    @Transactional
    public Herramientas update(Long id, HerramientasDTO dto, MultipartFile file) {
        Herramientas existente = herramientasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + id));
        existente.setCodigo(dto.codigo());
        existente.setNombre(dto.nombre());
        existente.setDescripcion(dto.descripcion());
        existente.setCategoria(dto.categoria());
        existente.setUbicacion(dto.ubicacion());
        existente.setEstado(dto.estado());
        existente.setStockMin(dto.stockMin());
        existente.setStockActual(dto.stockActual());
        existente.setValor(dto.valor());
        if (file != null && !file.isEmpty()) {
            if (existente.getImagen() != null && !existente.getImagen().isEmpty()) {
                fileStorageService.deleteFile(existente.getImagen());
            }
            String nuevoNombreImagen = fileStorageService.storeFile(file);
            existente.setImagen(nuevoNombreImagen);
        }
        return herramientasRepository.save(existente);
    }
    @Transactional
    public void delete(Long id) {
        Herramientas herramienta = herramientasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + id));
        herramienta.setActivo(false);
        herramienta.setEstado("ELIMINADO");
        herramientasRepository.save(herramienta);
    }
}