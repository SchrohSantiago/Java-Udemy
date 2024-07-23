package org.schroh.lambdaTarea;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EjemploLambdaTarea {
    public static void main(String[] args) {
        Function<String, Map<String, Integer>> solucion = (frase) -> {

            Map<String, Integer> palabras = new HashMap<>();

            String[] arrPalabras = frase.split(" ");  // Separamos la frase por palabras en un arreglo



            for (String palabra: arrPalabras){
                palabra = palabra.toLowerCase();

                if (!palabras.containsKey(palabra)){
                    palabras.put(palabra, 1);
                } else {
                    palabras.put(palabra, palabras.get(palabra) + 1);
                }
            }

            // Encontrar el valor maximo
            Integer maxValue = Collections.max(palabras.values());

            Map<String, Integer> palabraMasRepetida = new HashMap<>();
            for (Map.Entry<String, Integer> maximo : palabras.entrySet()){
                if (maximo.getValue().equals(maxValue)){
                    palabraMasRepetida.put(maximo.getKey(),maximo.getValue());
                }
            }



            return palabraMasRepetida;
        };


        Map<String, Integer> resultado = solucion.apply("hola hola hola hola hola la la de de de de tate");
        System.out.println(resultado);
    }
}
