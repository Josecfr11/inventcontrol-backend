package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.ventas.requests.VentaDTO;
import com.inventcontrol.backend.dtos.ventas.requests.VentaRequestDTO;
import com.inventcontrol.backend.dtos.ventas.responses.VentaResponseDTO;
import com.inventcontrol.backend.entities.Ventas;
import com.inventcontrol.backend.services.IVentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class VentasController {

    private final IVentasService service;

    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<VentaResponseDTO> create(@RequestBody VentaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
}