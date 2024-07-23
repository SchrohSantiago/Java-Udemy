package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmptyEjemplos {
    public static void main(String[] args) {

        long count = Stream
                .of("Pato Gonzales", "Paco Ramriez", "Pipi Tumona", "")
                .filter(String::isEmpty) // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos
                .peek(System.out::println)  // Es un debugger, para ver como van quedando nuestros elementos
                .count();
        System.out.println("count = " + count);

    }
}
