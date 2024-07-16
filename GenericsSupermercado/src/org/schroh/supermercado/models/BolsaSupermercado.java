package org.schroh.supermercado.models;

import org.schroh.supermercado.interfaces.IProducto;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T> implements IProducto<T> {
    List<T> bolsa;

    public BolsaSupermercado(List<T> bolsa) {
        this.bolsa = new ArrayList<>(); // Si es generico incluir el diamante
    }

    @Override
    public void addProducto(T producto){
        if (bolsa.size() < 5) {
            this.bolsa.add(producto); // Agrega el producto generico a la lista generica
        } else {
            throw new RuntimeException("La bolsa ya esta llena");
        }
    }

    @Override
    public List<T> getProductos(){
        if (bolsa != null){
            return bolsa;
        } else {
            throw new RuntimeException("No hay productos en la bolsa");
        }

    }
}




