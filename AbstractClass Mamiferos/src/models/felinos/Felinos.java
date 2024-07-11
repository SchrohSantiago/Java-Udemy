package models.felinos;

import models.Mamiferos;

abstract public class Felinos extends Mamiferos {
    protected Float garras;
    protected Integer velocidad;


    public Felinos(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, Float garras, Integer velocidad) {
        super(altura, habitat, largo, nombreCientifico, peso);
        this.garras = garras;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "garras=" + garras +
                ", velocidad=" + velocidad;
    }
}
