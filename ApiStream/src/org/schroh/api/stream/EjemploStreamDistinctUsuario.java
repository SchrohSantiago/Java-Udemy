package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {
        // EL DISTINCT HACE QUE LOS VALORES REPETIDOS SE MUESTREN UNA SOLA VEZ, SIRVE PARA QUITAR ELEMENTOS REPETIDOS

        Stream<Usuario> nombres = Stream.of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);

    }
}
