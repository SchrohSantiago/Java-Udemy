package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .flatMap(u -> {
                               if (u.getNombre().equals("Pipi")){ // El flat devuelve un STREAM simepre
                                   return Stream.of(u);
                               }
                               return Stream.empty(); // Si no retornamos un Stream vacio
                         })
                        .peek(System.out::println);  // Es un debugger, para ver como van quedando nuestros elementos


//        List<Usuario> list = nombres.collect(Collectors.toList()); // collect es un metodo que implementa Collectors lo cual convierte en este caso un Stream en una lista.



        nombres.forEach(System.out::println);

    }
}
