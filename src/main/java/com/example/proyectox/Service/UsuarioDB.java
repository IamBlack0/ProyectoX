package com.example.proyectox.Service;

import com.example.proyectox.Models.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDB {
    Connection conexion;

public UsuarioDB(){
    conexion = new Conexion().abrirDB();
}

public List<Usuarios> ObtenerUsuarios(){
    try {
        Statement stmt = conexion.createStatement();
        String query = "SELECT * FROM usuarios";

        List<Usuarios> usuarios = new ArrayList<>();
        ResultSet result = stmt.executeQuery(query);
        while (result.next()) {
            Usuarios usuario = new Usuarios(
                    result.getString("nombre_usuario"),
                    result.getString("correo_usuario"),
                    result.getString("contra_usuario"),
                    result.getInt("rol_usuario")
            );

            usuarios.add(usuario);
        }

        result.close();
        stmt.close();
        return usuarios;

    } catch (Exception e) {
        int x = 1;
    }
    return null;
}

}
