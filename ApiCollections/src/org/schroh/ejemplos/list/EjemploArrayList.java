package org.schroh.ejemplos.list;

import org.schroh.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;


public class EjemploArrayList {
    public static void main(String[] args) {


        List<Alumno> al = new ArrayList<>(); // Los metodos vistos funcionan para todas las LISTAS

        System.out.println(al + ", size = " + al.size());
        System.out.println("esta vacia = " + al.isEmpty());
        al.add(new Alumno("Carlos",5));
        al.add(new Alumno("Jorge",8));
        al.add(1, new Alumno("Esteban",2));
//        al.set(2, new Alumno("Will",2));

        System.out.println(al + ", size = " + al.size());

        al.remove(new Alumno("Will", 8)); // el remove utiliza el equals, si no coinciden todos los valores no lo elimina...
//        al.remove(2);

        System.out.println(al + ", size= " + al.size());

        boolean b = al.contains(new Alumno("Jorge",8));
        System.out.println(b);


        Object a[] = al.toArray();
        for (int i = 0; i < a.length; i++){
            System.out.println("Desde el arreglo: " + a[i]);
        }
    }
}
