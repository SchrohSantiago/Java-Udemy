package org.schroh.interfaces.repositorio.lista;

import org.schroh.interfaces.modelo.Producto;
import org.schroh.interfaces.repositorio.AbstractListRepositorio;
import org.schroh.interfaces.repositorio.Direccion;
import org.schroh.interfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {


    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource); // A partir de los datos originales de dataSource creamos una segunda lsita

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC){
                resultado = this.ordenar(campo,a,b);
            } else if (dir == Direccion.DESC) {
                resultado = this.ordenar(campo,b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    private int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;

        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
        }

        return resultado;
    }
}
