package models;

abstract public class Mamiferos {
    protected String habitat;
    protected Float altura;
    protected Float largo;
    protected Float peso;
    protected String nombreCientifico;

    public Mamiferos(Float altura, String habitat, Float largo, String nombreCientifico, Float peso) {
        this.altura = altura;
        this.habitat = habitat;
        this.largo = largo;
        this.nombreCientifico = nombreCientifico;
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public String getHabitat() {
        return habitat;
    }

    public Float getLargo() {
        return largo;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public Float getPeso() {
        return peso;
    }

    abstract public String comer();

    abstract public String dormir();

    abstract public String correr();

    abstract public String comunicarse();

    @Override
    public String toString() {
        return "altura=" + altura +
                ", habitat='" + habitat +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico;
    }
}
