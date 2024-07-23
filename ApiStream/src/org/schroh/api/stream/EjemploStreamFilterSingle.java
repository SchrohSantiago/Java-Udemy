package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .filter(u -> u.getNombre().equals("Pipix")) // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos
                        .peek(System.out::println);  // Es un debugger, para ver como van quedando nuestros elementos


        Optional<Usuario> usuario = nombres.findFirst(); // collect es un metodo que implementa Collectors lo cual convierte en este caso un Stream en una lista.
        // System.out.println(usuario.orElse(new Usuario("Unlastname","Unammed")));  // ORELSE metodo que si no se encuenta el usuario devolvemos un valor por defecto
        // System.out.println(usuario.orElseGet(() -> new Usuario("Unlastname","Unammed")));

        if (usuario.isPresent()){ // isPresent es un metodo de OPTIONAL para manejar estos casos
            System.out.println(usuario.get().getNombre());
        } else {
            System.out.println("No se encontro el objeto");
        }

        System.out.println(usuario.orElseThrow());
    }
}
