package org.schrohsanti.abstractclassform.form.elementos;

public class TextareaForm extends  ElementoForm {
    private int filas;
    private int columnas;

    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int columnas, int filas) {
        super(nombre);
        this.columnas = columnas;
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    @Override
    public String dibujarHtml() {
        return "<textarea name='" + this.nombre
                + "' cols='" + this.columnas
                + "' rows='" + this.filas + "'>" + this.valor + "</textarea>";
    }
}
