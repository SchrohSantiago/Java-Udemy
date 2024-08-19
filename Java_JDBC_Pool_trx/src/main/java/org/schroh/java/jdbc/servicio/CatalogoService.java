package org.schroh.java.jdbc.servicio;

import org.schroh.java.jdbc.modelo.Categoria;
import org.schroh.java.jdbc.modelo.Producto;
import org.schroh.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.schroh.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.schroh.java.jdbc.repositorio.Repositorio;
import org.schroh.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoService implements Service{
   private Repositorio<Producto> productoRepositorio;
   private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoService() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            productoRepositorio.setConn(conn);
            return productoRepositorio.listar();
        }
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            productoRepositorio.setConn(conn);
            return productoRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try { // En caso de que falle el guardar para el RollBack
                nuevoProducto = productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback(); // Incluimos el RollBack
                e.printStackTrace();
            }
            return nuevoProducto;
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException { // EL IMPLEMENTO DE ROLLBACK UNICMANETE CON LOS MODIFICADRES DE TABLAS NO CON LOS METODOS DE CONSULTA
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try { // En caso de que falle el guardar para el RollBack
                productoRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback(); // Incluimos el RollBack
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()) { // try para setear la conexion con la base de datos
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try { // En caso de que falle el guardar para el RollBack
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback(); // Incluimos el RollBack
                e.printStackTrace();
            }
            return nuevaCategoria;
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.porId(id);
        }
    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            categoriaRepositorio.setConn(conn);

            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try { // En caso de que falle el guardar para el RollBack
                categoriaRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback(); // Incluimos el RollBack
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){ // try para setear la conexion con la base de datos
            productoRepositorio.setConn(conn); // Aca realizamos la conexion con los dos repos, ya que interactuan los dos
            categoriaRepositorio.setConn(conn);

            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try { // En caso de que falle el guardar para el RollBack
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback(); // Incluimos el RollBack
                e.printStackTrace();
            }
        }
    }
}
