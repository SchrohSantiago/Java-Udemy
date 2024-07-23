package org.schroh.api.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        //Stream<String> nombres = Stream.of("Pato","Paco","Pipi"); // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
        // nombres.forEach(System.out::println);

//        String[] arr = {"Pato","Paco","Pipi"};
//        Stream<String> nombres = Arrays.stream(arr);
//        nombres.forEach(System.out::println);

//        Stream<String> nombres = Stream.<String>builder()
//                .add("Jorge")
//                .add("Marisa")
//                .add("Tony")
//                .build();
//
//        nombres.forEach(System.out::println);

        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Jorge");

        Stream<String> nombres = lista.stream();
        nombres.forEach(System.out::println);

        lista.stream().forEach(System.out::println);
    }
}
