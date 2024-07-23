package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Guzman","Jorge"));
        lista.add(new Usuario("Garcia","Juan"));
        lista.add(new Usuario("Schroh","Santiago"));
        lista.add(new Usuario("Martinez","Eze"));
        lista.add(new Usuario("Schroeder","Esteban"));
        lista.add(new Usuario("Cuttini","Tony"));
        lista.add(new Usuario("Lopez","Angela"));

        long t1 = System.currentTimeMillis();
        String nombres = lista.stream()
                .parallel()  // PARALLEL HACE QUE SE EJECUTEN TODOS A LA VEZ
                .map(u -> u.toString().toUpperCase())
                .peek(System.out::println)
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (nombre.contains("Esteban".toUpperCase())){
                        return Stream.of(nombre);
                    } else {
                        return Stream.empty();
                    }
                })
                .findAny().orElse("");// asi convertimos una lista a Stream

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 -t1));
        System.out.println(nombres);
    }
}
