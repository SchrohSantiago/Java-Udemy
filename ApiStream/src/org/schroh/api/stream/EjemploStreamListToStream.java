package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Guzman","Jorge"));
        lista.add(new Usuario("Garcia","Juan"));
        lista.add(new Usuario("Schroh","Santiago"));
        lista.add(new Usuario("Martinez","Eze"));
        lista.add(new Usuario("Schroeder","Esteban"));
        lista.add(new Usuario("Cuttini","Tony"));
        lista.add(new Usuario("Lopez","Angela"));

        Stream<String> nombres = lista.stream()
                .map(u -> u.getNombre()
                .toUpperCase()
                .concat(" ")
                .concat(u.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if (nombre.contains("Esteban".toUpperCase())){
                        return Stream.of(nombre);
                    } else {
                        return Stream.empty();
                    }
                })
                .map(String::toLowerCase)
                .peek(System.out::println);// asi convertimos una lista a Stream

        System.out.println(nombres.count());
    }
}
