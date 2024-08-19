package org.schroh.java.jdbc;

import org.schroh.java.jdbc.modelo.Categoria;
import org.schroh.java.jdbc.modelo.Producto;
import org.schroh.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.schroh.java.jdbc.repositorio.Repositorio;
import org.schroh.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        // Implementacion de AUTOCLOSE para cerrar de manera automatica la conexion con la BD de una manera mas legible y ordenada
        try (Connection conn = ConexionBaseDatos.getInstance()) // Abrimos la conexion con la base de datos llamando a el metodo de la clase que implementa el patron Singleton
         {
             Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
             System.out.println("============= Listar ================");

             repositorio.listar().forEach(System.out::println);

             System.out.println("============= Obtener por id ================");

             System.out.println(repositorio.porId(2L));

             System.out.println("============= Insertar nuevo producto ================");
             Producto p = new Producto();
             p.setNombre("Teclado Logitech");
             p.setPrecio(210);
             p.setFechaRegistro(new Date());

             Categoria c = new Categoria();
             c.setNombre("Tecnologia");
             c.setId(3L);
             p.setCategoria(c);

             repositorio.guardar(p);
             System.out.println("Producto guardado con exito");
             repositorio.listar().forEach(System.out::println);

         } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
