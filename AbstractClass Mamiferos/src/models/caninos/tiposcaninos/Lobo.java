package models.caninos.tiposcaninos;

import models.caninos.Caninos;

public class Lobo extends Caninos {
    private Integer numeroCamada;

    public Lobo(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, String color, Float tamanoColmillos, Integer numeroCamada) {
        super(altura, habitat, largo, nombreCientifico, peso, color, tamanoColmillos);
        this.numeroCamada = numeroCamada;
    }

    public Integer getNumeroCamada() {
        return numeroCamada;
    }

    @Override
    public String comer() {
        return "El lobo " + getNombreCientifico() + " debe comer 1.21kg de carne vacuna diaria, en lo posbile distribuidas en tres comidas \n";
    }

    @Override
    public String dormir() {
        return "El lobo " + getNombreCientifico() + " debe dormir minimo 6 horas diarias, junto a su numero de manada: " + getNumeroCamada();
    }

    @Override
    public String correr() {
        return "El lobo " + getNombreCientifico() +" debe correr 2 horas netas diarias, para mantenerse en forma";
    }

    @Override
    public String comunicarse() {
        return getNumeroCamada().equals(1) ? "El guardaparque tiene prohibido acercarse a esta manada" : "El guardaparque debe estar como minimo a 3 metros de distancia de la manada";
    }

    @Override
    public String toString() {
        return super.toString() +
                "numeroCamada=" + numeroCamada + "\n";
    }
}
