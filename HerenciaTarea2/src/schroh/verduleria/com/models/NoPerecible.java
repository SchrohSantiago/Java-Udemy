package schroh.verduleria.com.models;

import schroh.verduleria.com.product.Producto;

public class NoPerecible extends Producto {
    private int contenido;
    private int calorias;

    public NoPerecible(String nombre, Double precio, int calorias, int contenido) {
        super(nombre, precio);
        this.calorias = calorias;
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Calorias: " + calorias +
                " Contenido: " + contenido;
    }
}
