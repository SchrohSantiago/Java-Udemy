package org.schroh.api.stream;

import org.schroh.api.stream.models.Factura;
import org.schroh.api.stream.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {

    public static void main(String[] args) {

        Usuario u1 = new Usuario("Deree", "Jhon");
        Usuario u2 = new Usuario("Derek", "Joe");

        u1.addFacturas(new Factura("Compras tecnologia"));
        u1.addFacturas(new Factura("compra muebles"));

        u2.addFacturas(new Factura("bicicleta"));
        u2.addFacturas(new Factura("pc GAMER"));

        List<Usuario> usuarios = Arrays.asList(u1,u2);

        // Si no utilizamos STREAM esta seria la forma convencional

//        for (Usuario u: usuarios){
//            for (Factura f: u.getFacturas()){
//                System.out.println(f.getDescripcion());
//            }
//        }

        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat("Cliente").concat(f.getUsuario().toString())));
    }
}
