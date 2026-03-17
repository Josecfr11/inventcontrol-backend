package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.compras.requests.CompraDetalleRequestDTO;
import com.inventcontrol.backend.dtos.compras.requests.CompraRequestDTO;
import com.inventcontrol.backend.dtos.compras.responses.CompraDetalleResponseDTO;
import com.inventcontrol.backend.dtos.compras.responses.CompraResponseDTO;
import com.inventcontrol.backend.entities.*;
import com.inventcontrol.backend.repositories.*;
import com.inventcontrol.backend.services.IComprasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComprasServiceImpl implements IComprasService {

    private final ComprasRepository comprasRepository;
    private final IProveedoresRepository proveedoresRepository;
    private final HerramientasRepository herramientasRepository;
    private final MovimientosRepository movimientosRepository; // Para el Kardex

    @Override
    @Transactional
    public CompraResponseDTO create(CompraRequestDTO dto) {

        Proveedores proveedor = proveedoresRepository.findById(dto.proveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Compras compra = new Compras();
        compra.setNumeroOrden(dto.numeroOrden());
        compra.setTotal(dto.total());
        compra.setEstado(dto.estado());
        compra.setObservaciones(dto.observaciones());
        compra.setProveedor(proveedor);

        List<ComprasDetalles> detalles = new ArrayList<>();

        for (CompraDetalleRequestDTO d : dto.detalles()) {

            Herramientas herramienta = herramientasRepository.findById(d.herramientaId())
                    .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));

            // 1. AUMENTAR EL STOCK (Es una entrada de mercancía)
            herramienta.setStockActual(herramienta.getStockActual() + d.cantidad());
            herramientasRepository.save(herramienta);

            // 2. REGISTRAR EN EL KARDEX AUTOMÁTICAMENTE
            Movimientos mov = new Movimientos();
            mov.setTipoMovimiento("ENTRADA");
            mov.setModuloOrigen("COMPRAS");
            mov.setCantidad(d.cantidad());
            mov.setDescripcion("Ingreso por Orden de Compra: " + dto.numeroOrden() + " | " + herramienta.getNombre());
            movimientosRepository.save(mov);

            // 3. CREAR EL DETALLE DE LA COMPRA
            ComprasDetalles detalle = new ComprasDetalles();
            detalle.setCompras(compra);
            // Tu entidad tiene el campo llamado "herramientas" en plural
            detalle.setHerramientas(herramienta);
            detalle.setCantidad(d.cantidad());
            detalle.setPrecioUnitarioCompra(d.precioUnitarioCompra());
            detalle.setSubtotal(d.subtotal());
            detalle.setNumSerie(d.numSerie());

            detalles.add(detalle);
        }

        compra.setComprasDetalles(detalles);

        Compras compraGuardada = comprasRepository.save(compra);

        return mapToResponse(compraGuardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraResponseDTO> findAll() {
        return comprasRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private CompraResponseDTO mapToResponse(Compras compra) {

        List<CompraDetalleResponseDTO> detalles =
                compra.getComprasDetalles().stream()
                        .map(d -> new CompraDetalleResponseDTO(
                                d.getHerramientas().getId(),
                                d.getHerramientas().getNombre(),
                                d.getCantidad(),
                                d.getPrecioUnitarioCompra(),
                                d.getSubtotal(),
                                d.getNumSerie()
                        ))
                        .toList();

        return new CompraResponseDTO(
                compra.getId(),
                compra.getNumeroOrden(),
                compra.getFechaRegistro(),
                compra.getTotal(),
                compra.getEstado(),
                compra.getObservaciones(),
                compra.getProveedor().getNombre(),
                detalles
        );
    }
}