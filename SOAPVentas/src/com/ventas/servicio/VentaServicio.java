package com.ventas.servicio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class VentaServicio {

    private static List<Producto> productos = new ArrayList<>();
    private static List<Venta> ventas = new ArrayList<>();

    public VentaServicio() {
        if (productos.isEmpty()) {
            productos.add(new Producto("Laptop", 2500.0));
            productos.add(new Producto("Mouse", 50.0));
            productos.add(new Producto("Teclado", 100.0));
        }
    }

    @WebMethod
    public List<Producto> listarProductos() {
        return productos;
    }

    @WebMethod
    public String registrarVenta(String nombreProducto, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                double total = p.getPrecio() * cantidad;
                ventas.add(new Venta(nombreProducto, cantidad, total));
                return "✅ Venta registrada. Total a pagar: $" + total;
            }
        }
        return "❌ Producto no encontrado.";
    }

    @WebMethod
    public List<Venta> obtenerHistorialVentas() {
        return ventas;
    }
}
