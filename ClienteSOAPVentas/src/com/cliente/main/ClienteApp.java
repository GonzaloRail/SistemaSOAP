package com.cliente.main;

import com.cliente.ventas.VentaServicio;
import com.cliente.ventas.VentaServicioService;
import com.cliente.ventas.Producto;
import com.cliente.ventas.Venta;
import java.util.List;

public class ClienteApp {
    public static void main(String[] args) {
        try {
            System.out.println("=== CLIENTE SOAP VENTAS ===");
            
            // Crear el servicio a partir del WSDL generado
            VentaServicioService servicio = new VentaServicioService();
            VentaServicio port = servicio.getVentaServicioPort();
            
            System.out.println("✅ Conexión al servicio establecida");
            
            // 1. Listar productos disponibles
            System.out.println("\n📦 PRODUCTOS DISPONIBLES:");
            List<Producto> productos = port.listarProductos();
            for (Producto p : productos) {
                System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
            }
            
            // 2. Registrar una venta
            System.out.println("\n💰 REGISTRANDO VENTA:");
            String respuesta1 = port.registrarVenta("Laptop", 2);
            System.out.println(respuesta1);
            
            String respuesta2 = port.registrarVenta("Mouse", 5);
            System.out.println(respuesta2);
            
            // Intentar venta de producto inexistente
            String respuesta3 = port.registrarVenta("Tablet", 1);
            System.out.println(respuesta3);
            
            // 3. Obtener historial de ventas
            System.out.println("\n📊 HISTORIAL DE VENTAS:");
            List<Venta> ventas = port.obtenerHistorialVentas();
            if (ventas.isEmpty()) {
                System.out.println("No hay ventas registradas.");
            } else {
                for (Venta v : ventas) {
                    System.out.println("- " + v.getProducto() + 
                                     " (Cantidad: " + v.getCantidad() + 
                                     ", Total: $" + v.getTotal() + ")");
                }
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}