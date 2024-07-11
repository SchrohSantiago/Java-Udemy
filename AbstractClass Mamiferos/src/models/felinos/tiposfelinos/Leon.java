package models.felinos.tiposfelinos;

import models.felinos.Felinos;

public class Leon extends Felinos {
    private Integer numeroManada;
    private Float potenciaRudigo;

    public Leon(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, Float garras, Integer velocidad, Integer numeroManada, Float potenciaRudigo) {
        super(altura, habitat, largo, nombreCientifico, peso, garras, velocidad);
        this.numeroManada = numeroManada;
        this.potenciaRudigo = potenciaRudigo;
    }

    public Integer getNumeroManada() {
        return numeroManada;
    }

    public Float getPotenciaRudigo() {
        return potenciaRudigo;
    }

    @Override
    public String comer() {
        return "Los leones deben comer minimamente 5kg de carne diarios para mantener bien su estado de salud";
    }

    @Override
    public String dormir() {
        return getNumeroManada() < 5 ? "la manada " + getNumeroManada() + " debe dormir en el sector A" : "la manada " + getNumeroManada() + " debe dormir en el sector B";
    }

    @Override
    public String correr() {
        return "Los leones deben correr 1 hora diaria";
    }

    @Override
    public String comunicarse() {
        return "Extremada cautela para el acercamiento para con los leones, utilizar proteccion absoluta";
    }

    @Override
    public String toString() {
        return super.toString() +
                "numeroManada=" + numeroManada +
                ", potenciaRudigo=" + potenciaRudigo + "\n";
    }
}
