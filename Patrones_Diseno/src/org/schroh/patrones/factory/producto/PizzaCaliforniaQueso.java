package org.schroh.patrones.factory.producto;

import org.schroh.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {
    public PizzaCaliforniaQueso(){
        super();
        nombre = "Pizza California Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rucula";
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Quezo roquefort");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35 min. a 100 C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequenos triangulos");
    }
}
