package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.clientes.requests.ClienteListDTO;
import com.inventcontrol.backend.services.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientesController {

    private final IClientesService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }


}
