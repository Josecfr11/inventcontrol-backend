package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.herramientas.requests.HerramientasDTO;
import com.inventcontrol.backend.entities.Herramientas;
import com.inventcontrol.backend.services.IHerramientasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@RequiredArgsConstructor
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class HerramientasController {

    private final IHerramientasService service;

    @GetMapping
    public ResponseEntity<List<Herramientas>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramientas> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Herramientas> create(
            @RequestPart("herramienta") String herramientaJson,
            @RequestPart("file") MultipartFile file
    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        HerramientasDTO dto = objectMapper.readValue(herramientaJson, HerramientasDTO.class);

        return ResponseEntity.ok(service.save(dto, file));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Herramientas> update(
            @PathVariable Long id,
            @RequestPart("herramienta") String herramientaJson,
            @RequestPart(value = "file", required = false) MultipartFile file // La foto es opcional
    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        HerramientasDTO dto = objectMapper.readValue(herramientaJson, HerramientasDTO.class);

        return ResponseEntity.ok(service.update(id, dto, file));
    }
}