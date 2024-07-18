package org.schroh.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        Set<String> ts = new TreeSet<>(); // Mayor costo de rendimiento, es ordenado, utiliza CompareTo para ordenar
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");
        ts.add("tres");

        System.out.println(ts);

        Set<Integer> numbers = new TreeSet<>((a, b) -> b.compareTo(a)); // Invertimos el orden utilizando lambda y el compareTo
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        System.out.println("numbers = " + numbers);
     }
}
