package org.schroh.patrones.factory;

import org.schroh.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.schroh.patrones.factory.producto.PizzaCaliforniaQueso;
import org.schroh.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {

        return switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
    }
}
