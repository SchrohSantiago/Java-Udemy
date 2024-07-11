package org.schror.interf.productos.models.libro;

import org.schror.interf.productos.models.Producto;
import org.schror.interf.productos.models.interfaces.ILibro;

import java.util.Date;

public class Libro extends Producto implements ILibro {
    private Date fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    public Libro(int precio, float remarque, String autor, String editorial, Date fechaPublicacion, String titulo) {
        super(precio, remarque);
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.titulo = titulo;
    }


    @Override
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    @Override
    public String getAutor() {
        return this.autor;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getEditorial() {
        return this.editorial;
    }

    @Override
    public double getPrecioVenta() {
        return this.precio * (this.precio * this.remarque);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha Publicacion: ").append(this.fechaPublicacion)
                .append("\n")
                .append("Autor: ")
                .append(this.autor)
                .append("\n")
                .append("Titulo: ")
                .append(this.titulo)
                .append("\n")
                .append("Editorial: ")
                .append(this.editorial)
                .append("\n")
                .append("Precio de venta: ")
                .append(getPrecioVenta())
                .append("\n");

        return sb.toString();
    }
}
