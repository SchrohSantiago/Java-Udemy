package org.schror.interf.productos.models.electronico;

public class TvLcd extends Electronico{
    private int pulgada;

    public TvLcd(int precio, float remarque, String fabricante, int pulgada) {
        super(precio, remarque, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return this.precio + (this.precio * this.remarque);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("pulgada: ").append(this.pulgada)
                .append("\n")
                .append("Precio de venta: ")
                .append(getPrecioVenta())
                .append("\n");

        return sb.toString();
    }
}
