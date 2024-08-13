package org.schroh.patrones.factory;

import org.schroh.patrones.factory.producto.PizzaNewYorkItaliana;
import org.schroh.patrones.factory.producto.PizzaNewYorkPeperoni;
import org.schroh.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {

        return switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPeperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}
