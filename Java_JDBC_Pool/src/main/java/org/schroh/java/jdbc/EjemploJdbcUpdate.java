package org.schroh.java.jdbc;

import org.schroh.java.jdbc.modelo.Producto;
import org.schroh.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.schroh.java.jdbc.repositorio.Repositorio;
import org.schroh.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        // Implementacion de AUTOCLOSE para cerrar de manera automatica la conexion con la BD de una manera mas legible y ordenada
        {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= Listar ================");

            repositorio.listar().forEach(System.out::println);

            System.out.println("============= Obtener por id ================");

            System.out.println(repositorio.porId(2L));

            System.out.println("============= Insertar nuevo producto ================");
            Producto p = new Producto();
            p.setId(3L);
            p.setNombre("Teclado Razer");
            p.setPrecio(700);
            repositorio.guardar(p);
            System.out.println("Producto actualizado con exito");
            repositorio.listar().forEach(System.out::println);
        }
    }
}
