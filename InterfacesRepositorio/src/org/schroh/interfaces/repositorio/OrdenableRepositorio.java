package org.schroh.interfaces.repositorio;

import org.schroh.interfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir); // Para ordenar a los clientes de manera ascendente o descendente
}
