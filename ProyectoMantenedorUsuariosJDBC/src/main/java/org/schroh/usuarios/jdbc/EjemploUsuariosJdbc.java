package org.schroh.usuarios.jdbc;

import org.schroh.usuarios.jdbc.modelos.Usuarios;
import org.schroh.usuarios.jdbc.repositorio.Repositorio;
import org.schroh.usuarios.jdbc.repositorio.UsuarioRepositorioImpl;
import org.schroh.usuarios.jdbc.util.ConexionBaseDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class EjemploUsuariosJdbc {
    Repositorio<Usuarios> repositorio = new UsuarioRepositorioImpl();
    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Usuarios> repositorio = new UsuarioRepositorioImpl();

            int opcionIndice = 0;

            Map<String, Integer> operaciones = new HashMap();
            operaciones.put("Actualizar", 1);
            operaciones.put("Eliminar", 2);
            operaciones.put("Agregar", 3);
            operaciones.put("Listar", 4);
            operaciones.put("Salir", 5);

            Object[] opArreglo = operaciones.keySet().toArray();




            do {
                Object opcion = JOptionPane.showInputDialog(null,
                        "Seleccione un Operación",
                        "Mantenedor de Usuarios",
                        JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);
                if (opcion == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
                } else {
                    opcionIndice = operaciones.get(opcion.toString());

                    switch (opcionIndice) {
                        case 1:
                            repositorio.guardar(actualizarUsuarioInput());
                            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                            break;
                        case 2:
                            repositorio.eliminar(eliminarUsuarioInput());
                            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                            break;
                        case 3:
                            repositorio.guardar(crearUsuarioInput());
                            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                            break;
                        case 4:
                            repositorio.listar().forEach(System.out::println);
                        case 5:
                            System.out.println("Salir");
                            break;
                    }
                }
            } while (opcionIndice != 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Usuarios actualizarUsuarioInput(){
        Usuarios usuarioToUpdate = new Usuarios();

            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", usuarioToUpdate.getUsername());
            String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email:", usuarioToUpdate.getEmail());
            String nuevaPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña:", usuarioToUpdate.getPassword());
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del usuario:", usuarioToUpdate.getId()));

            usuarioToUpdate.setUsername(nuevoNombre);
            usuarioToUpdate.setEmail(nuevoEmail);
            usuarioToUpdate.setPassword(nuevaPassword);
            usuarioToUpdate.setId(id);

        return usuarioToUpdate;
    }

    public static Usuarios crearUsuarioInput(){
        Usuarios newUser = new Usuarios();

        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:", newUser.getUsername());
        String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email:", newUser.getEmail());
        String nuevaPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña:", newUser.getPassword());


        newUser.setUsername(nuevoNombre);
        newUser.setEmail(nuevoEmail);
        newUser.setPassword(nuevaPassword);

        return newUser;
    }

    public static Long eliminarUsuarioInput(){
        return Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del usuario: "));
    }
}
