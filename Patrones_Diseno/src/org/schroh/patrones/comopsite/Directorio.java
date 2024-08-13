package org.schroh.patrones.comopsite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente{
    private List<Componente> hijos;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Directorio addComponente(Componente c){
        hijos.add(c);
        return this;
    }

    public void removeComponente(Componente c){
        hijos.remove(c);
    }

    @Override
    public String mostrar() { // Metodo recursivo que tambien implementaran los hijos
        StringBuilder sb = new StringBuilder();
        sb.append(nombre)
                .append("/")
                .append("\n");

        for (Componente hijo: hijos){
            sb.append(hijo.mostrar())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean buscar(String nombre) {
        if(this.nombre.equalsIgnoreCase(nombre)){
            return true;
        }
        for (Componente hijo: this.hijos){
            if (hijo.buscar(nombre)){
                return true;
            }
        }
        return false;
    }
}
