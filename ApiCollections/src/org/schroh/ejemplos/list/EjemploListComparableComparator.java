package org.schroh.ejemplos.list;

import org.schroh.ejemplos.modelo.Alumno;


import java.util.*;


public class EjemploListComparableComparator {
    public static void main(String[] args) {


        List<Alumno> sa = new ArrayList<>(); // Los metodos vistos funcionan para todas las LISTAS

        sa.add(new Alumno("Carlos",5));
        sa.add(new Alumno("Jorge",8));
        sa.add(new Alumno("Will",2));
        sa.add(new Alumno("Will",2));

//        sa.sort((a, b) -> a.getNota().compareTo(b.getNota()));
//        sa.sort(Comparator.comparing((Alumno a) -> a.getNombre()).reversed());
        sa.sort(Comparator.comparing(Alumno::getNombre).reversed());
        System.out.println("\n Iterando con expresiones lambda \n");

//        sa.forEach(a -> System.out.println(a));
        sa.forEach(System.out::println);   // SUPER CONCISO
    }
}
