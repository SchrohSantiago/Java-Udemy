package org.schror.interf.productos.models;

import org.schror.interf.productos.models.interfaces.IProducto;

abstract public class Producto implements IProducto {
    protected int precio;
    protected float remarque;

    public Producto(int precio, float remarque) {
        this.precio = precio;
        this.remarque = remarque;
    }

     public int getPrecio(){
        return precio;
     };

    public float getRemarque(){
        return remarque;
    }
}
