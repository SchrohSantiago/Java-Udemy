package models;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLlegada;
    private Integer cantidadPasajeros;

    public Vuelo(Integer cantidadPasajeros, String destino, Date fechaLlegada, String nombre, String origen) {
        this.cantidadPasajeros = cantidadPasajeros;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.nombre = nombre;
        this.origen = origen;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }



    @Override
    public String toString() {
        return "Vuelo Nombre: " + nombre + ", "
                + "Origen: " + origen + ", "
                + "Destino: " + destino + ", "
                + "Fecha de llegada: " + fechaLlegada + "\n";
    }
}

