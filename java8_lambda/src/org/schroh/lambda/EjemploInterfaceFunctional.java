package org.schroh.lambda;

import org.schroh.lambda.aritmetica.Aritmetica;
import org.schroh.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {

        Aritmetica suma = Double::sum;
        Aritmetica resta = (a,b) -> a - b;
        Aritmetica division = (a,b) -> a / b;
        Aritmetica multiplicacion = (a,b) -> a * b;

        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10,5, division));
        System.out.println(cal.computar(10, 5, resta));
        System.out.println(cal.computar(10, 5, (a,b) -> a * b));

        System.out.println(cal.computarConBiFunction(10234,32,(a, b) -> a * b));
    }
}
