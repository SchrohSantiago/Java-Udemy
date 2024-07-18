package org.schroh.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        Set<String> hs = new HashSet<>();  // No permite elementos duplicados y tampoco mantiene orden.
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");

        List<String> lista = new ArrayList<>(hs);  // El parentesis transforma el Set en un ArrayList
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println(hs);

        boolean b = hs.add("tres");
        System.out.println(b);
        System.out.println(hs);
    }
}
