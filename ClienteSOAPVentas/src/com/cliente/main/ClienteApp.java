package com.cliente.main;

import com.cliente.ventas.VentaServicio;
import com.cliente.ventas.VentaServicio_Service;

public class ClienteApp {
    public static void main(String[] args) {
        // Creamos el servicio a partir del WSDL generado
        VentaServicio_Service servicio = new VentaServicio_Service();
        VentaServicio port = servicio.getVentaServicioPort();

        // Llamamos a un método del servicio
        String respuesta = port.registrarProducto("Laptop", 2500.00);
        System.out.println("Respuesta del servicio: " + respuesta);
    }
}
