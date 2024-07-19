package org.schroh.lambda;

import org.schroh.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        // CONSUMER DE 1 ARGUMENTO

        Consumer<Date> consumidor = saludo -> { // Aca simplemente implementamos el metodo, pero no se ejecuta
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(saludo));
        };
        consumidor.accept(new Date());  // se ejecuta cuando seguido del nombre colocamos el .accept y el argumento

        // CONSUMER DE 2 ARGUMENTOS

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + ", tiene: " + edad + " anios");
        };

        consumidorBi.accept("Eduardo",64);

        // CONSUMER SIMPLIFICADO

        Consumer<String> consumidor2 = System.out::println;


        // CONSUMER CON ARRAYS

        List<String> nombres = Arrays.asList("Andres","Pepe","Jorge");
        nombres.forEach(consumidor2);

        // BICONSUMER CON CLASES

        Usuario usuario = new Usuario();

//        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> {
//            persona.setNombre(nombre);
//        };

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre; // Es lo mismo que arriba pero mas conciso

        asignarNombre.accept(usuario, "jorge");
        System.out.println("Nombre usuario: " + usuario.getNombre());


        // EXPRESION LAMBDA SUPPLIER - No recibe argumento solamente devuelve un valor (Proovedor)

        Supplier<String> proveedor = () -> { // dentro de <> es el tipo de dato que retorna
            return "Hola mundo!";
        };

        Supplier<String> proveedorOptimizado = () -> "Hola soy lambda supplier";


        System.out.println(proveedorOptimizado.get()); // Debemos utilizar el get para obtener el valor

        Supplier<Usuario> crearUsuario = Usuario::new; // Crea un objeto

        crearUsuario.get();
    }
}
