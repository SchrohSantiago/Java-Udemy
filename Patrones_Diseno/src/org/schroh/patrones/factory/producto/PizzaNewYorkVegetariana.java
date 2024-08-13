package org.schroh.patrones.factory.producto;

import org.schroh.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        super(); // Para obtener la lista de ingredientes
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Rucula");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min. a 150C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortar la pizza en cudardos");
    }
}
