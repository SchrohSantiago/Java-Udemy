package models.caninos.tiposcaninos;

import models.caninos.Caninos;

public class Perro extends Caninos {
    private Integer fuerzaMordida;

    public Perro(Float altura, String habitat, Float largo, String nombreCientifico, Float peso, String color, Float tamanoColmillos, Integer fuerzaMordida) {
        super(altura, habitat, largo, nombreCientifico, peso, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public Integer getFuerzaMordida(){
        return fuerzaMordida;
    }


    @Override
    public String comer() {
        return "Los perros deben comer entre 2kg de carne vacuna diaria";
    }

    @Override
    public String dormir() {
        return "Los perros deben dormir mas de 5 horas diarias";
    }

    @Override
    public String correr() {
        return "Los perros deben ser trasladados 2 veces por dia a la zona larga para que puedan correr";
    }

    @Override
    public String comunicarse() {
        return getFuerzaMordida() > 9 ? "Acercarse con la proteccion completa al perro" : "El guardaparques puede acercarse con una proteccion media al perro";
    }

    @Override
    public String toString() {
        return super.toString() +
                "fuerzaMordida=" + fuerzaMordida + "\n";
    }
}
