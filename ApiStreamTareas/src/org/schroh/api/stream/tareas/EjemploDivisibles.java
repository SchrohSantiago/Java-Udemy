package org.schroh.api.stream.tareas;

import java.util.Arrays;
import java.util.stream.DoubleStream;


public class EjemploDivisibles {
    public static void main(String[] args) {

        int[] numeros = new int[100];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = i + 1;
        }

        DoubleStream resultado = Arrays.stream(numeros)
                .filter(n -> n % 10 != 0)
                .mapToDouble(n -> (double)n)
                .map(n -> n / 2)
                .reduce(Double::sum).stream();


        resultado.forEach(System.out::println);

    }
}
