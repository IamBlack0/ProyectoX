package com.example.proyectox.Service;

import com.example.proyectox.Models.Usuarios;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDB {
    Connection conexion;

    public UsuarioDB(){
        conexion = new Conexion().abrirDB();
    }

    public Usuarios registrarUsuario(Usuarios usuario) {
        try {
            String query = "INSERT INTO usuarios (nombre_usuario, correo_usuario, contra_usuario, rol_usuario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getCorreo_usuario());
            stmt.setString(3, usuario.getContra_usuario());
            stmt.setInt(4, usuario.getRol_usuario());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId_usuario(generatedKeys.getInt(1));
                }
                else {
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

    //PARA VERIFICAR SI EL USUARIO EXISTE
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






    //PARA INICIO DE SESION
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
                return usuario;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
