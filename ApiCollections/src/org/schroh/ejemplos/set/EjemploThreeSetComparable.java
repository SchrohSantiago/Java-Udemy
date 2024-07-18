package org.schroh.ejemplos.set;

import org.schroh.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Set;
import java.util.TreeSet;

public class EjemploThreeSetComparable {
    public static void main(String[] args) {

//        Set<Alumno> sa = new TreeSet<>((a,b) -> a.getNombre().compareTo(b.getNombre()));
        Set<Alumno> sa = new TreeSet<>(comparing(Alumno::getNota)); // Hace lo mismo que utilizar el compareTo pero de manera mucho mas simple
        sa.add(new Alumno("Carlos",5));
        sa.add(new Alumno("Jorge",8));
        sa.add(new Alumno("Will",2));
        sa.add(new Alumno("Will",3));

        System.out.println(sa);
    }
}
