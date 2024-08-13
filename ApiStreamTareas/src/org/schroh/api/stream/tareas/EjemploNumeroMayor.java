package org.schroh.api.stream.tareas;

import java.util.Arrays;
import java.util.function.Function;

public class EjemploNumeroMayor {
    public static void main(String[] args) {

        Double[] numeros = {1d,76d,455d,4234d,92385d,123213.123,2312d};

        Function<Double[], Double> mayorNumero = n -> Arrays.stream(n).reduce(0d, (n1,n2) -> n1 > n2 ? n1: n2);

        Double resultado = mayorNumero.apply(numeros);
        System.out.println(resultado);


    }
}
