package com.cliente.main;

import com.cliente.ventas.VentaServicio;
import com.cliente.ventas.VentaServicioService;
import com.cliente.ventas.Producto;
import com.cliente.ventas.Venta;
import java.util.List;
import java.util.Scanner;

public class ClienteConsola {
    private static VentaServicio port;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        try {
            // Conectar al servicio
            System.out.println("🔌 Conectando al servicio SOAP mejorado...");
            VentaServicioService servicio = new VentaServicioService();
            port = servicio.getVentaServicioPort();
            System.out.println("✅ Conexión establecida exitosamente!\n");
            
            // Menú principal
            mostrarMenu();
            
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con el servicio: " + e.getMessage());
            System.err.println("🔧 Asegúrate de que el servidor SOAP esté ejecutándose en el puerto 9090");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║         🛒 SISTEMA DE VENTAS MEJORADO            ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. 📦 Ver todos los productos                   ║");
            System.out.println("║  2. 🏷️  Ver productos por categoría              ║");
            System.out.println("║  3. ✅ Ver productos disponibles                 ║");
            System.out.println("║  4. ❌ Ver productos agotados                    ║");
            System.out.println("║  5. ⚠️  Ver productos con poco stock             ║");
            System.out.println("║  6. 💰 Registrar nueva venta                     ║");
            System.out.println("║  7. 📊 Ver historial de ventas                   ║");
            System.out.println("║  8. 📈 Ver estadísticas                          ║");
            System.out.println("║  9. 🔍 Consultar stock específico                ║");
            System.out.println("║ 10. 📥 Agregar stock                             ║");
            System.out.println("║ 11. 🔄 Actualizar datos                          ║");
            System.out.println("║  0. 🚪 Salir                                     ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("👉 Selecciona una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                System.out.println();
                
                switch (opcion) {
                    case 1: mostrarTodosLosProductos(); break;
                    case 2: mostrarProductosPorCategoria(); break;
                    case 3: mostrarProductosDisponibles(); break;
                    case 4: mostrarProductosAgotados(); break;
                    case 5: mostrarProductosBajoStock(); break;
                    case 6: registrarVenta(); break;
                    case 7: mostrarHistorial(); break;
                    case 8: mostrarEstadisticas(); break;
                    case 9: consultarStock(); break;
                    case 10: agregarStock(); break;
                    case 11: System.out.println("🔄 Datos actualizados!"); break;
                    case 0: System.out.println("👋 ¡Gracias por usar el sistema de ventas mejorado!"); break;
                    default: System.out.println("❌ Opción no válida. Por favor, selecciona del 0 al 11.");
                }
                
                if (opcion != 0) {
                    System.out.println("\n⏎ Presiona ENTER para continuar...");
                    scanner.nextLine();
                    System.out.println();
                }
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingresa un número válido.\n");
                opcion = -1;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + "\n");
                opcion = -1;
            }
            
        } while (opcion != 0);
    }
    
    private static void mostrarTodosLosProductos() {
        try {
            System.out.println("📦 TODOS LOS PRODUCTOS:");
            System.out.println("═══════════════════════════════════════════════════════════════");
            
            List<Producto> productos = port.listarProductos();
            
            if (productos.isEmpty()) {
                System.out.println("🚫 No hay productos disponibles.");
            } else {
                System.out.printf("%-3s %-20s %-12s %-8s %-15s%n", "#", "PRODUCTO", "PRECIO", "STOCK", "CATEGORÍA");
                System.out.println("───────────────────────────────────────────────────────────────");
                
                int contador = 1;
                for (Producto p : productos) {
                    String estadoStock = p.getStock() == 0 ? "❌ AGOTADO" : 
                                       p.getStock() <= 5 ? "⚠️ POCO" : "✅ OK";
                    
                    System.out.printf("%-3d %-20s $%-11.2f %-8s %-15s %s%n", 
                                    contador++, 
                                    p.getNombre(), 
                                    p.getPrecio(),
                                    p.getStock(),
                                    p.getCategoria(),
                                    estadoStock);
                }
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener productos: " + e.getMessage());
        }
    }
    
    private static void mostrarProductosPorCategoria() {
        try {
            // Primero mostrar categorías disponibles
            System.out.println("🏷️ CATEGORÍAS DISPONIBLES:");
            List<String> categorias = port.listarCategorias();
            
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println((i + 1) + ". " + categorias.get(i));
            }
            
            System.out.print("\n📝 Ingresa el nombre de la categoría: ");
            String categoria = scanner.nextLine().trim();
            
            if (categoria.isEmpty()) {
                System.out.println("❌ La categoría no puede estar vacía.");
                return;
            }
            
            List<Producto> productos = port.listarProductosPorCategoria(categoria);
            
            if (productos.isEmpty()) {
                System.out.println("🚫 No se encontraron productos en la categoría: " + categoria);
            } else {
                System.out.println("\n📦 PRODUCTOS EN CATEGORÍA: " + categoria.toUpperCase());
                System.out.println("═══════════════════════════════════════════════════");
                
                for (int i = 0; i < productos.size(); i++) {
                    Producto p = productos.get(i);
                    System.out.printf("%d. %-20s - $%-8.2f (Stock: %d)%n", 
                                    (i + 1), p.getNombre(), p.getPrecio(), p.getStock());
                }
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener productos por categoría: " + e.getMessage());
        }
    }
    
    private static void mostrarProductosDisponibles() {
        try {
            System.out.println("✅ PRODUCTOS DISPONIBLES:");
            System.out.println("═══════════════════════════════════════════════════");
            
            List<Producto> productos = port.listarProductosDisponibles();
            
            if (productos.isEmpty()) {
                System.out.println("🚫 No hay productos con stock disponible.");
            } else {
                for (int i = 0; i < productos.size(); i++) {
                    Producto p = productos.get(i);
                    System.out.printf("%d. %-20s - $%-8.2f | Stock: %d | %s%n", 
                                    (i + 1), p.getNombre(), p.getPrecio(), 
                                    p.getStock(), p.getCategoria());
                }
                System.out.printf("\n💡 Total de productos disponibles: %d%n", productos.size());
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener productos disponibles: " + e.getMessage());
        }
    }
    
    private static void mostrarProductosAgotados() {
        try {
            System.out.println("❌ PRODUCTOS AGOTADOS:");
            System.out.println("═══════════════════════════════════════════════════");
            
            List<Producto> productos = port.listarProductosAgotados();
            
            if (productos.isEmpty()) {
                System.out.println("🎉 ¡Excelente! No hay productos agotados.");
            } else {
                for (int i = 0; i < productos.size(); i++) {
                    Producto p = productos.get(i);
                    System.out.printf("%d. %-20s - $%-8.2f | %s%n", 
                                    (i + 1), p.getNombre(), p.getPrecio(), p.getCategoria());
                }
                System.out.printf("\n⚠️ Total de productos agotados: %d%n", productos.size());
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener productos agotados: " + e.getMessage());
        }
    }
    
    private static void mostrarProductosBajoStock() {
        try {
            System.out.print("📊 Ingresa el umbral de stock bajo (ej: 10): ");
            String umbralStr = scanner.nextLine().trim();
            
            int umbral = Integer.parseInt(umbralStr);
            
            System.out.println("\n⚠️ PRODUCTOS CON POCO STOCK (≤ " + umbral + "):");
            System.out.println("═══════════════════════════════════════════════════");
            
            List<Producto> productos = port.listarProductosBajoStock(umbral);
            
            if (productos.isEmpty()) {
                System.out.println("✅ No hay productos con stock bajo.");
            } else {
                for (int i = 0; i < productos.size(); i++) {
                    Producto p = productos.get(i);
                    System.out.printf("%d. %-20s - Stock: %d | %s%n", 
                                    (i + 1), p.getNombre(), p.getStock(), p.getCategoria());
                }
                System.out.printf("\n📋 Total de productos con stock bajo: %d%n", productos.size());
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Por favor, ingresa un número válido para el umbral.");
        } catch (Exception e) {
            System.out.println("❌ Error al obtener productos con bajo stock: " + e.getMessage());
        }
    }
    
    private static void registrarVenta() {
        try {
            // Mostrar productos disponibles primero
            mostrarProductosDisponibles();
            System.out.println();
            
            // Solicitar nombre del producto
            System.out.print("🏷️ Ingresa el nombre exacto del producto: ");
            String nombreProducto = scanner.nextLine().trim();
            
            if (nombreProducto.isEmpty()) {
                System.out.println("❌ El nombre del producto no puede estar vacío.");
                return;
            }
            
            // Solicitar cantidad
            System.out.print("🔢 Ingresa la cantidad: ");
            String cantidadStr = scanner.nextLine().trim();
            
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                
                if (cantidad <= 0) {
                    System.out.println("❌ La cantidad debe ser mayor a 0.");
                    return;
                }
                
                // Procesar la venta
                System.out.println("⏳ Procesando venta...");
                String respuesta = port.registrarVenta(nombreProducto, cantidad);
                
                // Mostrar resultado con formato
                System.out.println("🎯 " + respuesta);
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingresa un número válido para la cantidad.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al registrar venta: " + e.getMessage());
        }
    }
    
    private static void mostrarHistorial() {
        try {
            System.out.println("📊 HISTORIAL DE VENTAS:");
            System.out.println("═══════════════════════════════════════════════════");
            
            List<Venta> ventas = port.obtenerHistorialVentas();
            
            if (ventas.isEmpty()) {
                System.out.println("📋 No hay ventas registradas aún.");
            } else {
                double totalGeneral = 0;
                System.out.printf("%-3s %-20s %-10s %-12s%n", "#", "PRODUCTO", "CANTIDAD", "TOTAL");
                System.out.println("─────────────────────────────────────────────────");
                
                for (int i = 0; i < ventas.size(); i++) {
                    Venta v = ventas.get(i);
                    System.out.printf("%-3d %-20s %-10d $%-11.2f%n", 
                                    (i + 1), 
                                    v.getProducto(), 
                                    v.getCantidad(), 
                                    v.getTotal());
                    totalGeneral += v.getTotal();
                }
                
                System.out.println("─────────────────────────────────────────────────");
                System.out.printf("💰 TOTAL GENERAL: $%.2f%n", totalGeneral);
                System.out.printf("📈 NÚMERO DE VENTAS: %d%n", ventas.size());
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener historial: " + e.getMessage());
        }
    }
    
    private static void mostrarEstadisticas() {
        try {
            System.out.println("📈 ESTADÍSTICAS DEL SISTEMA:");
            System.out.println("═══════════════════════════════════════════════════");
            
            String estadisticas = port.obtenerEstadisticas();
            System.out.println(estadisticas);
            
        } catch (Exception e) {
            System.out.println("❌ Error al obtener estadísticas: " + e.getMessage());
        }
    }
    
    private static void consultarStock() {
        try {
            System.out.print("🔍 Ingresa el nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();
            
            if (nombreProducto.isEmpty()) {
                System.out.println("❌ El nombre del producto no puede estar vacío.");
                return;
            }
            
            String resultado = port.consultarStock(nombreProducto);
            System.out.println("📊 " + resultado);
            
        } catch (Exception e) {
            System.out.println("❌ Error al consultar stock: " + e.getMessage());
        }
    }
    
    private static void agregarStock() {
        try {
            System.out.print("📦 Ingresa el nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();
            
            if (nombreProducto.isEmpty()) {
                System.out.println("❌ El nombre del producto no puede estar vacío.");
                return;
            }
            
            System.out.print("➕ Ingresa la cantidad a agregar: ");
            String cantidadStr = scanner.nextLine().trim();
            
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                
                if (cantidad <= 0) {
                    System.out.println("❌ La cantidad debe ser mayor a 0.");
                    return;
                }
                
                String resultado = port.agregarStock(nombreProducto, cantidad);
                System.out.println("📈 " + resultado);
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingresa un número válido para la cantidad.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error al agregar stock: " + e.getMessage());
        }
    }
}