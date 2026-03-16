package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteUpdateDTO;
import com.inventcontrol.backend.dtos.clientes.requests.ClienteNewDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteByIdDTO;
import com.inventcontrol.backend.dtos.clientes.responses.ClienteListDTO;
import com.inventcontrol.backend.services.IClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final IClientesService iClientesService;

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> findAll() {
        System.out.println(iClientesService.findAll());
        return ResponseEntity.ok(iClientesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteByIdDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iClientesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Clientes> create(@RequestBody ClienteNewDTO clienteNewDTO) {
        return ResponseEntity.ok(iClientesService.save(clienteNewDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        iClientesService.updateCliente(id, clienteUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iClientesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
