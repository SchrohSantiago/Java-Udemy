import org.schroh.supermercado.models.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Lacteo lacteo = new Lacteo("Yogurt", 3d, 300, 140);
        Lacteo lacteo2 = new Lacteo("Crema", 3d, 320, 110);

        BolsaSupermercado<Lacteo> bolsaDeLacteos = new BolsaSupermercado<>(new ArrayList<>());
        bolsaDeLacteos.addProducto(lacteo);
        bolsaDeLacteos.addProducto(lacteo2);


        for (Lacteo l: bolsaDeLacteos.getProductos()){
            System.out.println("Nombre: " + l.getNombre()
                    + " Precio: " + l.getPrecio()
                    + " Cantidad: " + l.getCantidad()
                    + " Proteinas: " + l.getProteinas());
        }

        System.out.println("\n");

        Limpieza limpieza = new Limpieza("Trapo", 8d, "quimicos", 2d);
        Limpieza limpieza2 = new Limpieza("Secador", 6d, "Tela", 1.5d);
        Limpieza limpieza3 = new Limpieza("Lavandina", 2.3d, "quimicos", 1d);

        BolsaSupermercado<Limpieza> bolsaDeLimpieza = new BolsaSupermercado<>(new ArrayList<>());
        bolsaDeLimpieza.addProducto(limpieza);
        bolsaDeLimpieza.addProducto(limpieza2);
        bolsaDeLimpieza.addProducto(limpieza3);

        for (Limpieza l: bolsaDeLimpieza.getProductos()){
            System.out.println("Nombre: " + l.getNombre()
                    + " Precio: " + l.getPrecio()
                    + " Componentes: " + l.getComponentes()
                    + " Litros: " + l.getLitros());
        }

        System.out.println("\n");

        Fruta fruta = new Fruta("Manzana",2d,"Roja",160);
        Fruta fruta2 = new Fruta("Pera",1.3d,"Amarilla",120);
        Fruta fruta3 = new Fruta("Banana",1.4d,"Amarilla",90);


        BolsaSupermercado<Fruta> bolsaDeFrutas = new BolsaSupermercado<>(new ArrayList<>());
        bolsaDeFrutas.addProducto(fruta);
        bolsaDeFrutas.addProducto(fruta2);
        bolsaDeFrutas.addProducto(fruta3);


        for (Fruta f: bolsaDeFrutas.getProductos()){
            System.out.println("Nombre: " + f.getNombre()
                    + " Precio: " + f.getPrecio()
                    + " Color: " + f.getColor()
                    + " Peso: " + f.getPeso());
        }

    }


}