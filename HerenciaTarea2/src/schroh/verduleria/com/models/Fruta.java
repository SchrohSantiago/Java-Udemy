package schroh.verduleria.com.models;

import schroh.verduleria.com.product.Producto;

public class Fruta extends Producto {
    private double peso;
    private String color;


    public Fruta(String nombre, Double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Color: " + color +
                " Peso: " + peso;
    }
}
