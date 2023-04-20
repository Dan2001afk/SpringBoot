package com.example.produc.controlador;

import com.example.produc.entidad.productos;
import com.example.produc.servicio.servicioProductos;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
@CrossOrigin(origins = "*",maxAge = 3600)

@RestController
public class controladorProducto {

    servicioProductos servicio = new servicioProductos();

    @GetMapping("cantidad/")
    public String cantidad() {
        return "total de productos registrados" + servicio.cantidadProductos();
    }

    @GetMapping("/listaProductos")
    public ArrayList<productos> serviciosProductos() {
        return servicio.mostrarLista();

    }

    @GetMapping("/precioMasBarato")
    public BigDecimal precioMasBarato() {
        return servicio.obtenerPrecioMasBarato();
    }


    @PostMapping("/descuento/{codigo}")
    public String aplicarDescuento(@PathVariable int codigo) {
        productos p = servicio.aplicarDescuento(codigo);
        if (p != null) {
            return "El producto con código " + p.getCodigo() + " ahora tiene un precio de " + p.getPrecio();
        } else {
            return "No se encontró ningún producto con el código especificado.";
        }
    }




}