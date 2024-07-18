package org.schroh.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();
        persona.put(null,"1234");
        persona.put("Nombre", "Juan");
        persona.put("Apellido", "Doe");
        persona.put("email", "juandoe@gmail.com");
        persona.put("edad","30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais","USA");
        direccion.put("estado","California");
        direccion.put("ciudad","Santa Barbara");

        persona.put("direccion",direccion);

        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("Nombre");
        System.out.println(nombre);
        String apellido = (String) persona.get("Apellido");
        System.out.println(apellido);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");

        System.out.println("El pais de Jhon es: " + pais + " y vive en: " + ciudad);

        persona.remove("Apellido");
        System.out.println(persona);

        boolean b2 = persona.containsKey("Apellido");
        System.out.println("b2 = " + b2);

        boolean b3 = persona.containsValue("30");
        System.out.println("b3 = " + b3);

        Collection<Object> valores = persona.values(); // para iterar unicamente los values
        for (Object v: valores){
            System.out.println(v);
        }

        Set<String> llaves = persona.keySet(); // para iterar unicamente las keys
        for (String k: llaves){
            System.out.println("k = " + k);
        }

        for (Map.Entry<String, Object> par: persona.entrySet()){  // Para iterar key and values
            System.out.println(par.getKey() + " --> " + par.getValue());
        }

        System.out.println("============================");

//        for (String llave: persona.keySet()){
//            Object valor = persona.get(llave);
//            if (valor instanceof Map){
//                Map<String, String> direccion2 = (Map<String, String>) valor;
//                System.out.println("El pais de " + persona.get("nombre" + ": " + direccion2.get("pais")));
//            } else {
//
//            }
//            System.out.println(llave + " --> " + valor);
//        }

        System.out.println("=============================");

        persona.forEach((llave, valor) ->{
            System.out.println(llave + " -->  "+ valor);
        });

        System.out.println("Total: " + persona.size());
    }
}
