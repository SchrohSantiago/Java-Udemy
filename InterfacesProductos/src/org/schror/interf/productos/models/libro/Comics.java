package org.schror.interf.productos.models.libro;

import org.schror.interf.productos.models.interfaces.ILibro;

import java.util.Date;

public class Comics extends Libro {
    private String personaje;

    public Comics(int precio, float remarque, String autor, String editorial, Date fechaPublicacion, String titulo, String personaje) {
        super(precio, remarque, autor, editorial, fechaPublicacion, titulo);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    @Override
    public String toString() {
        return super.toString() + "Personaje: " + this.personaje + "\n";
    }
}
