package org.schroh.api.stream;

import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {
        // EL DISTINCT HACE QUE LOS VALORES REPETIDOS SE MUESTREN UNA SOLA VEZ, SIRVE PARA QUITAR ELEMENTOS REPETIDOS

        Stream<String> nombres = Stream.of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet")
                .distinct();
                  // Es un debugger, para ver como van quedando nuestros elementos


        nombres.forEach(System.out::println);

    }
}
