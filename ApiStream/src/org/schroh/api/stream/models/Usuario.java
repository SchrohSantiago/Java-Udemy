package org.schroh.api.stream.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellido;
    private Integer id;
    private static int ultimoId;

    private List<Factura> facturas;

    public Usuario(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.id = ++ultimoId;
        this.facturas = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addFacturas(Factura facturas) {
        this.facturas.add(facturas);
        facturas.setUsuario(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
