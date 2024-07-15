package org.schroh.interfaces.repositorio.lista;

import org.schroh.interfaces.modelo.Cliente;
import org.schroh.interfaces.repositorio.AbstractListRepositorio;
import org.schroh.interfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) { // Ediar y los demas meotods que dejamos en esta clase es porque son propios, poseen diferente getters y setters segun las distintas clases por ende no pueden ser genericos...
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }



    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource); // A partir de los datos originales de dataSource creamos una segunda lsita

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

    private int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;

            switch (campo){
                case "id" ->
                    resultado = a.getId().compareTo(b.getId());
                case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
                case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
            }

        return resultado;
    }
}
