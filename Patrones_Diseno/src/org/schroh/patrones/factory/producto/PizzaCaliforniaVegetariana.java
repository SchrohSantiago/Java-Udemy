package org.schroh.patrones.factory.producto;

import org.schroh.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {
    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza California Vegetariana";
        masa = "Masa delgada Light";
        salsa = "Salsa BBQ Light";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Berenjena");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20 min. a 180 C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en cuadraditos");
    }
}
