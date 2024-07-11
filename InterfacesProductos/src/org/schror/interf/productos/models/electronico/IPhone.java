package org.schror.interf.productos.models.electronico;

public class IPhone extends Electronico{
    private String color;
    private String modelo;

    public IPhone(int precio, float remarque, String fabricante, String color, String modelo) {
        super(precio, remarque, fabricante);
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public double getPrecioVenta() {
        return this.precio + (this.precio * this.remarque);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append("Modelo: ")
                .append(this.modelo)
                .append("\n")
                .append("Color: ")
                .append(this.color)
                .append("\n")
                .append("Precio de venta: ")
                .append(getPrecioVenta())
                .append("\n");

        return sb.toString();
    }
}
