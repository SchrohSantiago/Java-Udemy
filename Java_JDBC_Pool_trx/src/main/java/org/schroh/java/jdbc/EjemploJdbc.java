package org.schroh.java.jdbc;

import org.schroh.java.jdbc.modelo.Categoria;
import org.schroh.java.jdbc.modelo.Producto;
import org.schroh.java.jdbc.servicio.CatalogoService;
import org.schroh.java.jdbc.servicio.Service;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        // Implementacion de AUTOCLOSE para cerrar de manera automatica la conexion con la BD de una manera mas legible y ordenada
        Service service = new CatalogoService();

        System.out.println("============= Listar ================");
        service.listar().forEach(System.out::println);

        System.out.println("============= Insertar nueva categoria =============");
        Categoria c = new Categoria();
        c.setNombre("Iluminacion");



        System.out.println("============= Insertar nuevo producto ================");
        Producto p = new Producto();
        p.setNombre("Foco led 25W");
        p.setPrecio(23);
        p.setFechaRegistro(new Date());
        p.setSku("1234533622");

        service.guardarProductoConCategoria(p,c);
        System.out.println("Producto guardado con exito");
        service.listar().forEach(System.out::println);

    }
}


