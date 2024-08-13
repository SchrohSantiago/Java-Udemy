package org.schroh.anotaciones;

import java.lang.annotation.*;

@Documented // Para agregar a la API doc
@Target(ElementType.FIELD) // Donde se va a ejecutar?
@Retention(RetentionPolicy.RUNTIME) // En que contexto se va a ejecutar?
public @interface JsonAtributo {
    String nombre() default "";// Por defalut le incluimos un espacio vacio a nombre
}
