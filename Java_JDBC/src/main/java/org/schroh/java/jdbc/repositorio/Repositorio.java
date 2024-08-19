package org.schroh.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio<T>{ // Realizamos una interfaz generica para que sea mas reutilizable
    List<T> listar();

    T porId(Long id);

    void guardar(T t); // Dentro del guardar tendremos el insert y el update

    void eliminar(Long id);
}
