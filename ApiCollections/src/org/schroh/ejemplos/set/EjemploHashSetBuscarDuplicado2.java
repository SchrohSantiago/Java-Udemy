package org.schroh.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {

        String[] peces = {"Corvina","Lenguado", "Pejerrey","Lenguado"};

        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();  // Creamos un Set para los duplicados
        for (String pez: peces){
            if (!unicos.add(pez)){
                duplicados.add(pez); // Agregamos los duplicados al Set
            }

        }

        unicos.removeAll(duplicados);  // Utilizamos removeAll para elimimar en una sola ejecucion todos los duplicados
        unicos.addAll(duplicados);

        System.out.println(unicos.size() + "Elementos no duplicados: " + unicos);
        System.out.println(duplicados);
    }


}
