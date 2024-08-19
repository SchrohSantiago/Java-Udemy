package org.schroh.usuarios.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/tareausuarios?serverTimezone=America/Argentina/Buenos_Aires"; // Debemos especificar la zona horaria
    private static String username = "root";
    private static String password = "1545492s";
    private static Connection connection;

    // Con la creacion de este metodo la clase puede ser invocada en otras clases para generar reutilizar la conexion a la base de datos sin la necesidad de crear varias conexiones ineficientes lo que generaria deficiencia en terminos de recursos
    public static Connection getInstance() throws SQLException {
        if(connection == null){ // Implmentamos el patron creacional singleton
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
