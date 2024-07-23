package org.schroh.api.stream;

import org.schroh.api.stream.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        // ANYMATCH es como un filter pero devuelve True o False, es mas para validacion
        boolean existe = Stream
                        .of("Pato Gonzales","Paco Ramriez","Pipi Tumona", "Pipi Rochet")
                        .map(nombre -> new Usuario(nombre.split(" ")[1], nombre.split(" ")[0])) // Of recibe un arreglo con valores y retorna el metodo Arrays.stream, basicamente convierte el arreglo en un arreglo stream
                        .peek(System.out::println)
                        .anyMatch(u -> u.getId().equals(7)); // Recbie la expresion PREDICATE de las funcioens lambda, entonces es boolean, si es true filtra los datos


        System.out.println(existe);


        // EJEMPLO PARA VER COMO SERIA SIN EL USO DE STREAM Y SUS METODOS..

        List<Usuario> lista = Arrays.asList(new Usuario("Gonzales","Pato"),
                new Usuario("Gonzales","Pato"),
                new Usuario("Perri","Juan"),
                new Usuario("Jorgi","Esteban"));


        // EL ANYMATCH reemplazaria todo este proceso convencional de utilizar un foreach
        boolean resultado = false;

        for (Usuario u: lista){
            if (u.getId().equals(3)){
                resultado = true;
                break;
            }
        }

        System.out.println(resultado);

    }
}
