package org.schrohsanti.abstractclassform.form.validador;

public class NoNuloValidador extends Validador{

    protected String mensaje = "el %s campo no puede ser nulo";
    @Override
    public boolean esValido(String valor) {
        return (valor != null);
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return "";
    }
}
