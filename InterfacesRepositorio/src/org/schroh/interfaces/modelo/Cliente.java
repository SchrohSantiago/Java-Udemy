package org.schroh.interfaces.modelo;

import java.util.Objects;

public class Cliente extends BaseEntity{

    private String nombre;
    private String apellido;


    public Cliente(String nombre, String apellido) {
        super();
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' ;

    }
}
