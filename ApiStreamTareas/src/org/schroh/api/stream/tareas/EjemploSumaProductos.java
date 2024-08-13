package org.schroh.api.stream.tareas;

import org.schroh.api.stream.tareas.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class EjemploSumaProductos {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto(4,"Pala",23));
        productos.add(new Producto(2,"Pinza",16));
        productos.add(new Producto(3,"Rueda",45));

        Double granTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();

        System.out.println(granTotal);
    }
}
