package com.inventcontrol.backend.services.impl;

import com.inventcontrol.backend.dtos.ventas.requests.VentaDTO;
import com.inventcontrol.backend.dtos.ventas.requests.VentaDetalleDTO;
import com.inventcontrol.backend.entities.Clientes;
import com.inventcontrol.backend.entities.Herramientas;
import com.inventcontrol.backend.entities.Ventas;
import com.inventcontrol.backend.entities.VentasDetalles;
import com.inventcontrol.backend.repositories.ClientesRepository;
import com.inventcontrol.backend.repositories.HerramientasRepository;
import com.inventcontrol.backend.repositories.VentasRepository;
import com.inventcontrol.backend.services.IVentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VentasServiceImpl implements IVentasService {
    private final VentasRepository ventasRepository;
    private final ClientesRepository clientesRepository;
    private final HerramientasRepository herramientasRepository;

    @Override
    @Transactional
    public Ventas create(VentaDTO dto) {

        Clientes cliente = clientesRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Ventas venta = new Ventas();
        venta.setNumeroFactura(dto.numeroFactura());
        venta.setEstado(dto.estado());
        venta.setTipoPago(dto.tipoPago());
        venta.setTotal(dto.total());
        venta.setCliente(cliente);
        List<VentasDetalles> listaDetalles = new ArrayList<>();

        for (VentaDetalleDTO detalleDTO : dto.detalles()) {
            Herramientas herramienta = herramientasRepository.findById(detalleDTO.herramientaId())
                    .orElseThrow(() -> new RuntimeException("Herramienta no encontrada: " + detalleDTO.herramientaId()));

            if (herramienta.getStockActual() < detalleDTO.cantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + herramienta.getNombre());
            }
            herramienta.setStockActual(herramienta.getStockActual() - detalleDTO.cantidad());
            herramientasRepository.save(herramienta);
            VentasDetalles detalle = new VentasDetalles();
            detalle.setHerramienta(herramienta);
            detalle.setCantidad(detalleDTO.cantidad());
            detalle.setPrecioUnitario(detalleDTO.precioUnitario());
            detalle.setSubtotal(detalleDTO.subtotal());

            detalle.setVenta(venta);

            listaDetalles.add(detalle);
        }
        venta.setDetalles(listaDetalles);
        return ventasRepository.save(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }
}