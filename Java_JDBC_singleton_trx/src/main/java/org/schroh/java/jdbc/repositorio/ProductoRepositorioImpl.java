package org.schroh.java.jdbc.repositorio;

import org.schroh.java.jdbc.modelo.Categoria;
import org.schroh.java.jdbc.modelo.Producto;
import org.schroh.java.jdbc.util.ConexionBaseDatos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                    "inner join categorias as c ON (p.categoria_id = c.id)")){
            while(rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }


    @Override
    public Producto porId(Long id) throws SQLException {
        Producto p = null;

        try (PreparedStatement stmt = getConnection(). // Utilizamos "prepareStatement" cuando recibe parametros
                prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                "                    inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = crearProducto(rs);
                }
            } // Ejecuta la consulta
        }

        return p;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId()>0){
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?"; // Recibe los 3 parametros, nombre, precio y fecha
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro, sku) VALUES(?,?,?,?,?)";
        }

        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());


            if(producto.getId() != null && producto.getId()>0){
                stmt.setLong(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
                stmt.setString(5, producto.getSku());
            }

            stmt.executeUpdate(); // Ejecuta las instrucciones de modificacion
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre("categoria");
        p.setCategoria(categoria);
        return p;
    }
}
