package com.ventas.servicio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService
public class VentaServicio {

    private static List<Producto> productos = new ArrayList<>();
    private static List<Venta> ventas = new ArrayList<>();

    public VentaServicio() {
        if (productos.isEmpty()) {
            // Inicializar productos con stock y categorías
            productos.add(new Producto("Laptop Gaming", 2500.0, 15, "Computadoras"));
            productos.add(new Producto("Laptop Oficina", 1200.0, 25, "Computadoras"));
            productos.add(new Producto("Mouse Gamer", 50.0, 100, "Periféricos"));
            productos.add(new Producto("Mouse Inalámbrico", 35.0, 75, "Periféricos"));
            productos.add(new Producto("Teclado Mecánico", 100.0, 50, "Periféricos"));
            productos.add(new Producto("Teclado Inalámbrico", 60.0, 80, "Periféricos"));
            productos.add(new Producto("Monitor 24\"", 300.0, 30, "Monitores"));
            productos.add(new Producto("Monitor 27\"", 450.0, 20, "Monitores"));
            productos.add(new Producto("Webcam HD", 80.0, 40, "Accesorios"));
            productos.add(new Producto("Auriculares", 120.0, 60, "Accesorios"));
        }
    }

    @WebMethod
    public List<Producto> listarProductos() {
        return productos;
    }

    @WebMethod
    public List<Producto> listarProductosPorCategoria(String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    @WebMethod
    public List<String> listarCategorias() {
        return productos.stream()
                .map(Producto::getCategoria)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @WebMethod
    public List<Producto> listarProductosDisponibles() {
        return productos.stream()
                .filter(p -> p.getStock() > 0)
                .collect(Collectors.toList());
    }

    @WebMethod
    public String registrarVenta(String nombreProducto, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                
                // Verificar stock disponible
                if (!p.hayStockSuficiente(cantidad)) {
                    return String.format("❌ Stock insuficiente. Disponible: %d unidades", p.getStock());
                }
                
                // Realizar la venta
                double total = p.getPrecio() * cantidad;
                p.reducirStock(cantidad);
                ventas.add(new Venta(nombreProducto, cantidad, total));
                
                return String.format("✅ Venta registrada. Total: $%.2f | Stock restante: %d", 
                                    total, p.getStock());
            }
        }
        return "❌ Producto no encontrado.";
    }

    @WebMethod
    public String agregarStock(String nombreProducto, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                p.aumentarStock(cantidad);
                return String.format("✅ Stock actualizado. Nuevo stock: %d unidades", p.getStock());
            }
        }
        return "❌ Producto no encontrado.";
    }

    @WebMethod
    public String consultarStock(String nombreProducto) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                return String.format("📦 %s - Stock disponible: %d unidades", 
                                    p.getNombre(), p.getStock());
            }
        }
        return "❌ Producto no encontrado.";
    }

    @WebMethod
    public List<Venta> obtenerHistorialVentas() {
        return ventas;
    }

    @WebMethod
    public String obtenerEstadisticas() {
        double totalVentas = ventas.stream().mapToDouble(Venta::getTotal).sum();
        int totalProductosVendidos = ventas.stream().mapToInt(Venta::getCantidad).sum();
        int productosConStock = (int) productos.stream().filter(p -> p.getStock() > 0).count();
        int productosAgotados = (int) productos.stream().filter(p -> p.getStock() == 0).count();
        
        return String.format(
            "📊 ESTADÍSTICAS:\n" +
            "💰 Total ventas: $%.2f\n" +
            "📦 Productos vendidos: %d unidades\n" +
            "✅ Productos con stock: %d\n" +
            "❌ Productos agotados: %d\n" +
            "🔄 Total de ventas: %d",
            totalVentas, totalProductosVendidos, productosConStock, productosAgotados, ventas.size()
        );
    }

    @WebMethod
    public List<Producto> listarProductosAgotados() {
        return productos.stream()
                .filter(p -> p.getStock() == 0)
                .collect(Collectors.toList());
    }

    @WebMethod
    public List<Producto> listarProductosBajoStock(int umbral) {
        return productos.stream()
                .filter(p -> p.getStock() > 0 && p.getStock() <= umbral)
                .collect(Collectors.toList());
    }
}