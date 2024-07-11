package models.felinos.tiposfelinos;

import models.felinos.Felinos;

public class Tigre extends Felinos {
    private String especieTigre;

    public Tigre(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, Float garras, Integer velocidad, String especieTigre) {
        super(altura, habitat, largo, nombreCientifico, peso, garras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return "Los tigres deben comer 1.45kg de carne vacuna separado en 4 veces diarias";
    }

    @Override
    public String dormir() {
        return "Los tigres deben dormir 2 veces por dia, minimamente 4 horas en total";
    }

    @Override
    public String correr() {
        return getEspecieTigre().equalsIgnoreCase("bengala") ? "El tigre de bengala debe correr apartado de los demas tigres " : "Los tigres minimamente deben correr 1 hora diaria";
    }

    @Override
    public String comunicarse() {
        return "Mucho cuidado con los tigres";
    }

    @Override
    public String toString() {
        return super.toString() +
                "especieTigre='" + especieTigre + "\n";
    }
}
