package org.schroh.java.jdbc.repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T>{ // Realizamos una interfaz generica para que sea mas reutilizable
    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    T guardar(T t) throws SQLException; // Dentro del guardar tendremos el insert y el update

    void eliminar(Long id) throws SQLException;

    void setConn(Connection conn);
}
