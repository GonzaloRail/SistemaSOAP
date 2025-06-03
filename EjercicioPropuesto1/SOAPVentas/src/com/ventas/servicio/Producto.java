package com.ventas.servicio;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto() {}  // Constructor vacío necesario para SOAP

    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para reducir stock
    public boolean reducirStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    // Método para aumentar stock
    public void aumentarStock(int cantidad) {
        this.stock += cantidad;
    }

    // Verificar si hay stock suficiente
    public boolean hayStockSuficiente(int cantidad) {
        return this.stock >= cantidad;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (Stock: %d) [%s]", 
                           nombre, precio, stock, categoria);
    }
}