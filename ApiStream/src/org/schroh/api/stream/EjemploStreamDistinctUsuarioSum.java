package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {
        // EL DISTINCT HACE QUE LOS VALORES REPETIDOS SE MUESTREN UNA SOLA VEZ, SIRVE PARA QUITAR ELEMENTOS REPETIDOS

        IntStream largoNombres = Stream.of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet", "Pipi Rochet")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length());

//        largoNombres.forEach(System.out::println);
        System.out.println(largoNombres.sum());
    }
}
