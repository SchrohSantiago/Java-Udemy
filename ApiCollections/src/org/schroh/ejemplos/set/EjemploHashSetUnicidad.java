package org.schroh.ejemplos.set;

import org.schroh.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        Set<Alumno> sa = new HashSet<>();
//        List<Alumno> sa = new ArrayList<>();

        sa.add(new Alumno("Carlos",5));
        sa.add(new Alumno("Jorge",8));
        sa.add(new Alumno("Will",2));
        sa.add(new Alumno("Will",2));

        System.out.println(sa);

        System.out.println("Iteraciones de las collections \n");

        for (Alumno a: sa){
            System.out.println(a);
        }

        System.out.println("\n Iterando usando While e Iterator \n");

        Iterator<Alumno> it = sa.iterator(); // El ITERATOR es un metodo seguro que recorre las colecciones e implementa metodos como next() para avanzar y obtener el siguiente elemento y hasNext() para verificar si hay mas elementos en la coleccion
        while(it.hasNext()){ // Mientras alla un proximo elemento
            Alumno a = it.next(); // Avanza y guarda el elemento
            System.out.println(a); // luego los imprime uno por uno
        }

        System.out.println("\n Iterando con expresiones lambda \n");

//        sa.forEach(a -> System.out.println(a));
        sa.forEach(System.out::println);   // SUPER CONCISO
    }
}
