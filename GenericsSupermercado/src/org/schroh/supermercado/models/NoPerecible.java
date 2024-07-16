package org.schroh.supermercado.models;

public class NoPerecible extends Producto{
    private int contenido;
    private int calorias;

    public NoPerecible(String nombre, Double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getContenido() {
        return contenido;
    }
}
