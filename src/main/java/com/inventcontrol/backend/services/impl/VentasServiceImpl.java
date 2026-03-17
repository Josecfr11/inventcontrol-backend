package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.ventas.requests.VentaDTO;
import com.inventcontrol.backend.dtos.ventas.requests.VentaDetalleDTO;
import com.inventcontrol.backend.dtos.ventas.requests.VentaRequestDTO;
import com.inventcontrol.backend.dtos.ventas.responses.VentaDetalleResponseDTO;
import com.inventcontrol.backend.dtos.ventas.responses.VentaResponseDTO;
import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.entities.Herramientas;
import com.inventcontrol.backend.entities.Movimientos; // <-- NUEVO IMPORT
import com.inventcontrol.backend.entities.Ventas;
import com.inventcontrol.backend.entities.VentasDetalles;
import com.inventcontrol.backend.repositories.ClientesRepository;
import com.inventcontrol.backend.repositories.HerramientasRepository;
import com.inventcontrol.backend.repositories.MovimientosRepository;
import com.inventcontrol.backend.repositories.VentasRepository;
import com.inventcontrol.backend.services.IVentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentasServiceImpl implements IVentasService {

    private final VentasRepository ventasRepository;
    private final ClientesRepository clientesRepository;
    private final HerramientasRepository herramientasRepository;
    private final MovimientosRepository movimientosRepository; // <-- 1. INYECTAR EL REPOSITORIO DE MOVIMIENTOS

    @Override
    @Transactional
    public VentaResponseDTO create(VentaRequestDTO dto) {

        Clientes cliente = clientesRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Ventas venta = new Ventas();
        venta.setNumeroFactura(dto.numeroFactura());
        venta.setEstado(dto.estado());
        venta.setTipoPago(dto.tipoPago());
        venta.setTotal(dto.total());
        venta.setCliente(cliente);

        List<VentasDetalles> detalles = new ArrayList<>();

        for (VentaDetalleDTO d : dto.detalles()) {

            Herramientas herramienta = herramientasRepository.findById(d.herramientaId())
                    .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));

            if (herramienta.getStockActual() < d.cantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + herramienta.getNombre());
            }

            // Descontamos el stock
            herramienta.setStockActual(herramienta.getStockActual() - d.cantidad());
            herramientasRepository.save(herramienta);

            // ---> 2. REGISTRAR EN EL KARDEX DE MOVIMIENTOS <---
            Movimientos mov = new Movimientos();
            mov.setTipoMovimiento("SALIDA");
            mov.setModuloOrigen("VENTAS");
            mov.setCantidad(-d.cantidad()); // Lo ponemos en negativo porque es una salida
            mov.setDescripcion("Venta Factura: " + dto.numeroFactura() + " | " + herramienta.getNombre());
            movimientosRepository.save(mov);
            // ---------------------------------------------------

            VentasDetalles detalle = new VentasDetalles();
            detalle.setVenta(venta);
            detalle.setHerramienta(herramienta);
            detalle.setCantidad(d.cantidad());
            detalle.setPrecioUnitario(d.precioUnitario());
            detalle.setSubtotal(d.subtotal());

            detalles.add(detalle);
        }

        venta.setDetalles(detalles);

        Ventas ventaGuardada = ventasRepository.save(venta);

        return mapToResponse(ventaGuardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VentaResponseDTO> findAll() {
        return ventasRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private VentaResponseDTO mapToResponse(Ventas venta) {

        List<VentaDetalleResponseDTO> detalles =
                venta.getDetalles().stream()
                        .map(d -> new VentaDetalleResponseDTO(
                                d.getHerramienta().getId(),
                                d.getHerramienta().getNombre(),
                                d.getCantidad(),
                                d.getPrecioUnitario(),
                                d.getSubtotal()
                        ))
                        .toList();

        return new VentaResponseDTO(
                venta.getId(),
                venta.getNumeroFactura(),
                venta.getEstado(),
                venta.getTipoPago(),
                venta.getTotal(),
                venta.getFecha(),
                venta.getCliente().getNombre(),
                detalles
        );
    }
}