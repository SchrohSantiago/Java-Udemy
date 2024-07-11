package org.schrohsanti.abstractclassform.form;

import org.schrohsanti.abstractclassform.form.elementos.ElementoForm;
import org.schrohsanti.abstractclassform.form.elementos.InputForm;
import org.schrohsanti.abstractclassform.form.elementos.SelectForm;
import org.schrohsanti.abstractclassform.form.elementos.TextareaForm;
import org.schrohsanti.abstractclassform.form.elementos.select.Opcion;
import org.schrohsanti.abstractclassform.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args){

        InputForm username = new InputForm("username", "text");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("password", "password");
        password.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(8,36));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(1,3)).addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("Experiencia", 9, 5);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");

        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "Cobol"));

        // Clase anonima
        ElementoForm saludar = new ElementoForm("Saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+ this.nombre + "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("campo deshabilitado");
        username.setValor("santi.schroh");
        password.setValor("123232");
        email.setValor("santi");
        edad.setValor("");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);// Crea un arreglo de listas

//        for (ElementoForm e: elementos){
//            System.out.println(e.dibujarHtml());
//            System.out.println("<br>");
//        }

        elementos.forEach(e -> {  // Expresion lambda
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> { // Lo que hacemos con la expresion lambda es verificar si el elemento no es valido con un segundo for each recorrer la lista de errores y mostrarlos por consola
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println); //err -> System.out.println(err
            }
        });
    }
}
