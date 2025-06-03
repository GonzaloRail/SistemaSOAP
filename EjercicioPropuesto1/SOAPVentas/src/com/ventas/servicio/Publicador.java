package com.ventas.servicio;

import javax.xml.ws.Endpoint;

public class Publicador {
    public static void main(String[] args) {
        // Publicamos el servicio en el puerto 9090 para evitar conflictos con el 8080
        String url = "http://localhost:9090/servicioVentas";
        Endpoint.publish(url, new VentaServicio());
        System.out.println("Servicio publicado en: " + url);
    }
}
