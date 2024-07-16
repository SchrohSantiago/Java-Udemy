package org.schroh.interfaces.repositorio;

import org.schroh.interfaces.repositorio.excepciones.AccesoDatoException;
import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar(); // Liste a los clientes
    T porId(Integer id) throws AccesoDatoException;  // Busque clientes por id
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
