package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.compras.requests.CompraRequestDTO;
import com.inventcontrol.backend.dtos.compras.responses.CompraResponseDTO;
import com.inventcontrol.backend.services.IComprasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class ComprasController {
    private final IComprasService comprasService;

    @GetMapping
    public ResponseEntity<List<CompraResponseDTO>> findAll() {
        return ResponseEntity.ok(comprasService.findAll());
    }

    @PostMapping
    public ResponseEntity<CompraResponseDTO> create(@RequestBody CompraRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comprasService.create(dto));
    }
}
