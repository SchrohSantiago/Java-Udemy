package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .filter(u -> u.getNombre().equals("Pipi")) // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos
                        .peek(System.out::println);  // Es un debugger, para ver como van quedando nuestros elementos


        List<Usuario> list = nombres.collect(Collectors.toList()); // collect es un metodo que implementa Collectors lo cual convierte en este caso un Stream en una lista.

//        list.forEach(System.out::println);

    }
}
