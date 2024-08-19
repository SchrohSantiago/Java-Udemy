package org.schroh.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_prueba?serverTimezone=America/Argentina/Buenos_Aires"; // Debemos especificar la zona horaria
    private static String username = "root";
    private static String password = "1545492s";
    private static BasicDataSource pool; // Declaracion del atributo pool

    // Con la creacion de este metodo la clase puede ser invocada en otras clases para generar reutilizar la conexion a la base de datos sin la necesidad de crear varias conexiones ineficientes lo que generaria deficiencia en terminos de recursos
    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){ // Implmentamos el patron creacional singleton
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); // Para iniciar 3 conexiones abiertas
            pool.setMinIdle(3); // Minimo de conexiones que esperan ser utilizadas
            pool.setMaxIdle(8); // Maximo de 8 conexiones inactivas
            pool.setMaxTotal(8); // Maximo de activas e inactivas
        }
        return pool;
    }

    // Metodo para obtener una sola conexion disponible del pool
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    };
}
