package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {

        // Count cuenta la cantidad de elementos
        long count = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .peek(System.out::println)
                        .count(); // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos


        System.out.println(count); // devuelve 4

    }
}
