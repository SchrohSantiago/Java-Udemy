package org.schroh.interfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar(); // Liste a los clientes
    T porId(Integer id);  // Busque clientes por id
    void crear(T t);
    void editar(T t);
    void eliminar(Integer id);
}
