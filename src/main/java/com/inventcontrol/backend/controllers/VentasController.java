package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.ventas.requests.VentaDTO;
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
@CrossOrigin(origins = "http://localhost:4200")
public class VentasController {
    private final IVentasService service;
    @GetMapping
    public ResponseEntity<List<Ventas>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<Ventas> create(@RequestBody VentaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
}