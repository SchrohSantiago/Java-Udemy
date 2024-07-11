package models;

public class Empleado extends Persona{
    private static Double remuneracion;
    private int empleadoId;

    public Empleado(String apellido, String direccion, String nombre, String numeroFiscal, Double remuneracion, int empleadoId) {
        super(apellido, direccion, nombre, numeroFiscal);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public Double getRemuneracion() {
        return remuneracion;
    }

    public static void aumentarRemuneracion(int porcentaje){
        remuneracion += porcentaje;
    }

    @Override
    public String toString() {
        return super.toString() +
                "empleadoId=" + empleadoId +
                ", remuneracion=" + remuneracion;

    }
}
