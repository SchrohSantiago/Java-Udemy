package org.schroh.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        // El primer argumento es el que recibe la funcion y el segundo argumento es el que devuelve
        Function<String, String>  f1 = param ->
                "Hola que tal! " + param;

        String resultado = f1.apply("jorge"); // Utilizamos apply para enviarle el argumento
        System.out.println(resultado);

        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("Jorgito"));

        // BIFUNCTION primeros dos argumentos de entrara y el tercero de retorno

        BiFunction<String, String, String> f3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("Andres", "jose");
        System.out.println(r2);

        BiFunction<String, String, Integer> f4 = String::compareTo; /*(a,b) -> a.compareTo(b)*/;
        System.out.println(f4.apply("andres","andres"));

        BiFunction<String, String, String> f5 = String::concat; /*(a,b) -> a.compareTo(b)*/;
        System.out.println(f5.apply("andres","andres"));
    }
}
