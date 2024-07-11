package models;

public class Gerente extends Empleado{
    private Double presupuesto;

    public Gerente(String apellido, String direccion, String nombre, String numeroFiscal, Double remuneracion, int empleadoId, Double presupuesto) {
        super(apellido, direccion, nombre, numeroFiscal, remuneracion, empleadoId);
        this.presupuesto = presupuesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {

        return  "///GERENTE///" + super.toString() +
                "presupuesto= " + presupuesto +
                '}';
    }
}
