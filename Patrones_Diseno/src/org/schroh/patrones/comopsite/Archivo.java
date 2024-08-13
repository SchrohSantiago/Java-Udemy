package org.schroh.patrones.comopsite;

public class Archivo extends Componente{
    public Archivo(String nombre) {
        super(nombre);
    }

    @Override
    public String mostrar() {
        return nombre;
    }

    @Override
    public boolean buscar(String nombre) {
        return this.nombre.equals(nombre);
    }
}
