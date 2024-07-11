import schroh.verduleria.com.models.*;

import schroh.verduleria.com.product.Producto;

public class Main {
    public static void main(String[] args) {


        Fruta manzana = new Fruta("manzana", 23D, 320, "Rojo");
        Fruta pera = new Fruta("pera", 14.5, 230, "Amarillo");

        Limpieza detergente = new Limpieza("Detergente", 10.0, "a", 2D);
        Limpieza limpiavidrios = new Limpieza("Limpiavidrios", 8.0, "b", 3D);

        Lacteo leche = new Lacteo("Leche", 20.0, 6, 8);
        Lacteo yogurt = new Lacteo("Yogurt", 15.0, 12, 5);

        NoPerecible arroz = new NoPerecible("Arroz", 12.0, 1000, 130);
        NoPerecible pasta = new NoPerecible("Pasta", 9.0, 500, 200);

        Producto.addProducto(manzana, pera, detergente);

        Producto.addProducto(pasta, arroz);

        Producto.addProducto(leche, yogurt, limpiavidrios);
        Producto.showProductos();

    }
}