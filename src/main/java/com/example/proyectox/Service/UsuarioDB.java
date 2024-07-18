package com.example.proyectox.Service;

import com.example.proyectox.Models.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDB {
    Connection conexion;

    public UsuarioDB() {
        conexion = new Conexion().abrirDB();
    }

    public Usuarios registrarUsuario(Usuarios usuario) {
        try {
            String query = "INSERT INTO usuarios (nombre_usuario, correo_usuario, contra_usuario, rol_usuario, img_usuario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getCorreo_usuario());
            stmt.setString(3, usuario.getContra_usuario());
            stmt.setInt(4, usuario.getRol_usuario());
            stmt.setString(5, usuario.getImg_usuario()); // Añadir img_usuario
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId_usuario(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            stmt.close();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existeCorreo(String correo) {
        try {
            String query = "SELECT 1 FROM usuarios WHERE correo_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            rs.close();
            stmt.close();
            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeNombreUsuario(String nombreUsuario) {
        try {
            String query = "SELECT 1 FROM usuarios WHERE nombre_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            boolean exists = rs.next();
            rs.close();
            stmt.close();
            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuarios iniciarSesion(String correo, String contrasena) {
        try {
            String query = "SELECT * FROM usuarios WHERE correo_usuario = ? AND contra_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setCorreo_usuario(rs.getString("correo_usuario"));
                usuario.setContra_usuario(rs.getString("contra_usuario"));
                usuario.setRol_usuario(rs.getInt("rol_usuario"));
                usuario.setImg_usuario(rs.getString("img_usuario")); // Añadido
                return usuario;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarImagenUsuario(int idUsuario, String nuevaImagen) {
        try {
            String query = "UPDATE usuarios SET img_usuario = ? WHERE id_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nuevaImagen);
            stmt.setInt(2, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los usuarios
    public List<Usuarios> obtenerUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM usuarios";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setCorreo_usuario(rs.getString("correo_usuario"));
                usuario.setContra_usuario(rs.getString("contra_usuario"));
                usuario.setRol_usuario(rs.getInt("rol_usuario"));
                usuario.setImg_usuario(rs.getString("img_usuario"));
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Eliminar un usuario
    public boolean eliminarUsuario(int idUsuario) {
        try {
            String query = "DELETE FROM usuarios WHERE id_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar un usuario (sin la imagen de perfil)
    public boolean actualizarUsuario(Usuarios usuario) {
        try {
            String query = "UPDATE usuarios SET nombre_usuario = ?, correo_usuario = ?, contra_usuario = ?, rol_usuario = ? WHERE id_usuario = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getCorreo_usuario());
            stmt.setString(3, usuario.getContra_usuario());
            stmt.setInt(4, usuario.getRol_usuario());
            stmt.setInt(5, usuario.getId_usuario());
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
