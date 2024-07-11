package org.schror.interf.productos.models.electronico;

import org.schror.interf.productos.models.Producto;
import org.schror.interf.productos.models.interfaces.IElectrico;

abstract public class Electronico extends Producto implements IElectrico {
    protected String fabricante;

    public Electronico(int precio, float remarque, String fabricante) {
        super(precio, remarque);
        this.fabricante = fabricante;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public abstract double getPrecioVenta();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fabricante: ").append(fabricante).append("\n");

        return sb.toString();
    }
}
