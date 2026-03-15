package com.inventcontrol.backend.services;

import com.inventcontrol.backend.dtos.herramientas.requests.HerramientasDTO;
import com.inventcontrol.backend.entities.Herramientas;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IHerramientasService {
    Herramientas save(HerramientasDTO dto, MultipartFile file);
    List<Herramientas> findAll();
    Herramientas findById(Long id);
    void delete(Long id);
    Herramientas update(Long id, HerramientasDTO dto, MultipartFile file);}
