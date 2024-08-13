package org.schroh.api.stream.tareas.models;

public class Producto {
    private double precio;
    private int cantidad;
    private String nombre;

    public Producto(int cantidad, String nombre, double precio) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
