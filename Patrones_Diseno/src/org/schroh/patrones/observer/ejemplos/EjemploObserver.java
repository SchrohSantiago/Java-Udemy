package org.schroh.patrones.observer.ejemplos;

import org.schroh.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google",1000);
        google.addObserver((observable, obj) -> {
            System.out.println("Jorge: " + observable);
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Ricardo: " + observable);
        });

        google.modificaPrecio(2000);
    }
}
