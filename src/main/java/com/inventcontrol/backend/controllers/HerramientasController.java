package com.inventcontrol.backend.controllers;

import com.inventcontrol.backend.services.dtos.herramientas.responses.HerramientasListDTO;
import com.inventcontrol.backend.services.IHerramientasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class HerramientasController {
//    private final IHerramientasService iHerramientaService;

    // GET: Listar todas las herramientas
//    @GetMapping
//    public ResponseEntity<List<HerramientasListDTO>> listarTodas() {
//        return ResponseEntity.ok(iHerramientaService.findAll());
//    }
////
//    // GET: Buscar una herramienta por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Herramienta> obtenerPorId(@PathVariable Long id) {
//        return iHerramientaService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // POST: Crear una nueva herramienta (Registro)
//    @PostMapping
//    public ResponseEntity<Herramienta> crear(@RequestBody Herramienta herramienta) {
//        Herramienta nuevaHerramienta = iHerramientaService.save(herramienta);
//        return new ResponseEntity<>(nuevaHerramienta, HttpStatus.CREATED);
//    }
//
//    // PUT: Actualizar una herramienta existente (Modificación total)
//    @PutMapping("/{id}")
//    public ResponseEntity<Herramienta> actualizar(@PathVariable Long id, @RequestBody Herramienta herramienta) {
//        try {
//            return ResponseEntity.ok(iHerramientaService.update(id, herramienta));
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // PATCH: Actualizar solo el stock (Modificación parcial)
//    @PatchMapping("/{id}/stock")
//    public ResponseEntity<Void> actualizarStock(@PathVariable Long id, @RequestParam Integer nuevoStock) {
//        iHerramientaService.updateStock(id, nuevoStock);
//        return ResponseEntity.noContent().build();
//    }
//
//    // DELETE: Eliminar una herramienta
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
//        iHerramientaService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
