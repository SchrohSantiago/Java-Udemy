package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream.of("Pato Gonzales","Paco Ramriez","Pipi Tumona")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .peek(u -> System.out.println(u.getApellido()))  // Es un debugger, para ver como van quedando nuestros elementos
                        .map(usuario -> {
                            String nombre = usuario.getNombre().toLowerCase();
                            String apellido = usuario.getApellido().toLowerCase();
                            usuario.setNombre(nombre);
                            usuario.setApellido(apellido);
                            return usuario;
                        });

        List<Usuario> list = nombres.collect(Collectors.toList()); // collect es un metodo que implementa Collectors lo cual convierte en este caso un Stream en una lista.

        list.forEach(System.out::println);

    }
}
