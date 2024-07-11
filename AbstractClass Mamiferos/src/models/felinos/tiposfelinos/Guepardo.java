package models.felinos.tiposfelinos;

import models.felinos.Felinos;

public class Guepardo extends Felinos {

    public Guepardo(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, Float garras, Integer velocidad) {
        super(altura, habitat, largo, nombreCientifico, peso, garras, velocidad);
    }

    @Override
    public String comer() {
        return "Los Guepardos deben comer mas de 3kg de carne vacuna diaria";
    }

    @Override
    public String dormir() {
        return "Los Guepardos deben dormir mas de 7 horas por dia";
    }

    @Override
    public String correr() {
        return "Los Guepardos deben correr minimamente 45 minutos diarios";
    }

    @Override
    public String comunicarse() {
        return "No pasar la valla para alimentar a los guepardos";
    }
}
