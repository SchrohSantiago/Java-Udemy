package org.schroh.ejemplos.list;

import org.schroh.ejemplos.modelo.Alumno;


import java.util.LinkedList;
import java.util.ListIterator;


public class EjemploLinkedList {
    public static void main(String[] args) {


        LinkedList<Alumno> enlazada = new LinkedList<>(); // Si necesitamos manipular datos por indice, posicion o tal, lo mejor es usar una LinkedList

        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("esta vacia = " + enlazada.isEmpty());
        enlazada.add(new Alumno("Carlos",5));
        enlazada.add(new Alumno("Jorge",8));
        enlazada.add(new Alumno("Esteban",2));
//        enlazada.set(2, new Alumno("Will",2));

        System.out.println(enlazada + ", size = " + enlazada.size());

        enlazada.addFirst(new Alumno("Zeus",5)); // Agrega en la cabeza de la lista
        enlazada.addLast(new Alumno("Olivia", 6)); // Agrega en la cola de la lista

        System.out.println(enlazada + ", size = " + enlazada.size());

        System.out.println("Primer elemento: " + enlazada.getFirst());
        System.out.println("Ultimo elemento: " + enlazada.getLast());
        System.out.println("Indice 2: " + enlazada.get(2));

        Alumno zeus = enlazada.removeFirst();
        enlazada.removeLast();
        System.out.println(enlazada + ", size = " + enlazada.size());

        ListIterator<Alumno> li = enlazada.listIterator();

        while(li.hasNext()){
            Alumno alumno = li.next();
            System.out.println(alumno);
        }
        System.out.println("==========================");
        while(li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }
    }
}
