package org.schroh.java.jdbc.servicio;

import org.schroh.java.jdbc.modelo.Categoria;
import org.schroh.java.jdbc.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    List<Producto> listar() throws SQLException;

    Producto porId(Long id) throws SQLException;

    Producto guardar(Producto producto) throws SQLException;

    void eliminar(Long id) throws SQLException;

    List<Categoria> listarCategoria() throws SQLException;

    Categoria guardarCategoria(Categoria categoria) throws SQLException;

    Categoria porIdCategoria(Long id) throws SQLException;

    void eliminarCategoria(Long id) throws SQLException;

    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}