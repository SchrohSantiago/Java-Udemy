package org.schror.interf.productos;

import org.schror.interf.productos.models.Producto;
import org.schror.interf.productos.models.electronico.IPhone;
import org.schror.interf.productos.models.electronico.TvLcd;
import org.schror.interf.productos.models.interfaces.IProducto;
import org.schror.interf.productos.models.libro.Comics;
import org.schror.interf.productos.models.libro.Libro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args) {

        IProducto[] productos = new Producto[6];

        IPhone iphone14 = new IPhone(750, 0.38f, "Apple", "Rojo", "14 pro max");
        IPhone iphone8 = new IPhone(220, 0.22f, "Apple", "Negro", "8 plus");

        productos[0] = iphone14;
        productos[1] = iphone8;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            Date date = dateFormat.parse("23-04-2018");
            Date date2 = dateFormat.parse("21-11-2017");

            Libro libro = new Libro(22, 0.7f, "Sidney Sheldon", "Kaplus", date, "Lo que se pierde en la oscuridad");
            Comics comics = new Comics(15,0.34f, "Shikohumu Aritaki", "Blinashi", date2, "Natdusen", "Natulu");

            productos[2] = libro;
            productos[3] = comics;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        TvLcd LgTV = new TvLcd(380, 0.62f, "LG", 65);
        productos[4] = LgTV;


        for (IProducto prod: productos){
            if (prod != null) {
                System.out.println(prod);
            }
        }

    }


}