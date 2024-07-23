package org.schroh.api.stream;

import java.util.stream.Stream;

public class EjemploStreamFilterReduceInt {
    public static void main(String[] args) {
        // EL DISTINCT HACE QUE LOS VALORES REPETIDOS SE MUESTREN UNA SOLA VEZ, SIRVE PARA QUITAR ELEMENTOS REPETIDOS

        Stream<Integer> nombres = Stream.of(5, 10, 23, 32)
                .distinct();
                  // Es un debugger, para ver como van quedando nuestros elementos
        

//        Integer resultado = nombres.reduce(0,(a,b) -> a + b);
        Integer resultado = nombres.reduce(0, Integer::sum);
        System.out.println(resultado);
    }
}
