package org.schroh.supermercado.models;

public class Fruta extends Producto{
    private double peso;
    private String color;

    public Fruta(String nombre, Double precio,  String color, double peso){
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
}
