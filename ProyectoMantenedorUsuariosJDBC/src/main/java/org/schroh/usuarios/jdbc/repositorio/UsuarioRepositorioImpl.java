package org.schroh.usuarios.jdbc.repositorio;

import org.schroh.usuarios.jdbc.modelos.Usuarios;
import org.schroh.usuarios.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuarios>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Usuarios> listar() {
        List<Usuarios> usuarios = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){
            while(rs.next()){
                Usuarios u = crearUsuarios(rs);
                usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    @Override
    public void guardar(Usuarios usuarios) {
        String sql;
        if (usuarios.getId() != null && usuarios.getId()>0){
            sql = "UPDATE usuarios SET email=?, username=?, password=? WHERE id=?";
        } else {
            sql = "INSERT INTO usuarios(email, username, password) VALUES(?,?,?)";
        }

        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, usuarios.getEmail());
            stmt.setString(2, usuarios.getUsername());
            stmt.setString(3, usuarios.getPassword());

            if(usuarios.getId() != null && usuarios.getId()>0){
                stmt.setLong(4, usuarios.getId());
            }

            stmt.executeUpdate(); // Ejecuta las instrucciones de modificacion
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuarios WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    private static Usuarios crearUsuarios(ResultSet rs) throws SQLException {
        Usuarios usuario = new Usuarios();
        usuario.setId(rs.getLong("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        return usuario;
    }
}
