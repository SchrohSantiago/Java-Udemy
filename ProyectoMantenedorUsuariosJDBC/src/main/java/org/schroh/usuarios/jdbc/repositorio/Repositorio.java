package org.schroh.usuarios.jdbc.repositorio;

import org.schroh.usuarios.jdbc.modelos.Usuarios;

import java.util.List;

public interface Repositorio <T>{
    public List<T> listar();

    public void guardar(T t); // Una metodologia que se implementa actualmente es en el mismo metodo guardar que se permita crear y editar

//    public void crear();

    public void eliminar(Long id);

//    public void editar();
}
