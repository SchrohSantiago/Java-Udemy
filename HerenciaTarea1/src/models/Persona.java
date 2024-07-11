package models;

public class Persona {
    private String nombre;
    private String apellido;
    private String numeroFiscal;
    private String direccion;

    public Persona(String apellido, String direccion, String nombre, String numeroFiscal) {
        this.apellido = apellido;
        this.direccion = direccion;
        this.nombre = nombre;
        this.numeroFiscal = numeroFiscal;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numeroFiscal='" + numeroFiscal + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}
