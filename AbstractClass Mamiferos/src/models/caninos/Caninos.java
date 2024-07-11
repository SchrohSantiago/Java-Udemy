package models.caninos;

import models.Mamiferos;

abstract public class Caninos extends Mamiferos {
    protected String color;
    protected Float tamanoColmillos;


    public Caninos(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, String color, Float tamanoColmillos) {
        super(altura, habitat, largo, nombreCientifico, peso);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "color='" + color + '\'' +
                ", tamanoColmillos=" + tamanoColmillos;
    }
}
