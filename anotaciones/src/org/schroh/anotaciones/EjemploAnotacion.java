package org.schroh.anotaciones;

import org.schroh.anotaciones.models.Producto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("Mesa Roble");
        p.setPrecio(21L);
        Field[] atributos = p.getClass().getDeclaredFields();

            String json = Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class)) // va a filtrar todos los campos o FIELDS que incluyan la anotacion
                .map(field -> {
                    field.setAccessible(true);
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? field.getName() // Si el campo asignado con la anotacion  en el atributo nombre no contiene nada le asignamos un nombre por defecto
                            : field.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        return "\"" + nombre + "\":\"" + field.get(p) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error al serializar a JSON: " + e.getMessage());
                    }


                })
                .reduce("{", (a,b) -> {
                         if ("{".equals(a)){
                            return a + b;
                         }
                         return a + ", " + b;
                        }).concat("}");

        System.out.println("json = " + json);
    }
}
