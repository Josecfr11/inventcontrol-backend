package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.dtos.ClienteListDTO;
import com.inventcontrol.backend.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }
}
