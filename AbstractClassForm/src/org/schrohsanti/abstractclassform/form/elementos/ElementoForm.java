package org.schrohsanti.abstractclassform.form.elementos;

import org.schrohsanti.abstractclassform.form.validador.LargoValidador;
import org.schrohsanti.abstractclassform.form.validador.Validador;
import org.schrohsanti.abstractclassform.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm {

    protected String valor; // Implementamos protected para que podamos utilizar valor sin los metodos get en las otras clases hijas
    protected String nombre; // Nombre nos referimos digamos que al label

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this(); // el this invoca las inicializaciones del contructor anterior para inicializar las listas
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;  // retornamos el mismo tipo de dato para poder concatenar el metodo
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido(){
        for (Validador v: validadores){ // recorremos la lista de validaciones
            if (v instanceof MensajeFormateable){ // si no es valido el valor
                this.errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre)); // agrega el mensaje de error que recordemos que es un metodo que aplica el polimorfismo es decir mismo metodo pero diferentes mensajes de respuesta segun sea la clase
            } else {
                this.errores.add(String.format(v.getMensaje(), nombre));
            }
        }
        return this.errores.isEmpty(); // si esta vacia retorna true, sino false
    }

    abstract public String dibujarHtml(); // Todas las clases hijas implementar su forma de render propia, no podemos definir el body aca


}
