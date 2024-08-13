package org.schroh.patrones.factory.ejemplo;

import org.schroh.patrones.factory.PizzaProducto;
import org.schroh.patrones.factory.PizzeriaCaliforniaFactory;
import org.schroh.patrones.factory.PizzeriaNewYorkFactory;
import org.schroh.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Santiago ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());


        System.out.println("pizza = " + pizza);
    }
}
