package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        Usuario usuario = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .peek(System.out::println)
                        .filter(u -> u.getId().equals(3)) // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos
                        // .findFirst().get(); // Para evitar el null pointer exception pordiamos utilizar orElseGet para crear un usuario default
                        .findFirst().orElseGet(() -> new Usuario("Unlastname","Unnamed"));
        System.out.println(usuario);
//

    }
}
