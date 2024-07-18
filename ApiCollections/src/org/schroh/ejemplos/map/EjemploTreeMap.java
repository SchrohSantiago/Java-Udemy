package org.schroh.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new TreeMap<>(Comparator.reverseOrder());
        persona.put("nombre", "Juan");
        persona.put("apellido", "Doe");
        persona.put("email", "juandoe@gmail.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");

        persona.put("direccion", direccion);
        System.out.println("Persona: " + persona);

    }
}