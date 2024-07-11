package org.schrohsanti.abstractclassform.form.validador;

public class RequeridoValidador extends Validador{

    protected String mensaje = "el campo %s es requerido";
    @Override
    public boolean esValido(String valor) {
        return (valor != null && !valor.isEmpty());
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }
}
