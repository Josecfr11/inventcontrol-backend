package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.movimientos.requests.MovimientoDTO;
import com.inventcontrol.backend.services.IMovimientosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientosController {
    private final IMovimientosService service;

    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
