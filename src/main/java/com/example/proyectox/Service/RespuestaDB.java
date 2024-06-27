package com.example.proyectox.Service;

import com.example.proyectox.Models.Historia;
import com.example.proyectox.Models.Respuesta;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class RespuestaDB {
    Connection conexion;

    public RespuestaDB(){
        conexion = new Conexion().abrirDB();
    }

    public List<Respuesta> ObtenerRespuestas(){
        try {
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM respuestas";

            List<Respuesta> respuestas = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Respuesta respuesta = new Respuesta(
                        result.getInt("id_respuestas"),
                        result.getString("respuesta"),
                        result.getInt("efecto_respuesta"),
                        result.getInt("id_respuesta_pregunta")
                );

                respuestas.add(respuesta);
            }

            result.close();
            stmt.close();
            return respuestas;

        } catch (Exception e) {
            int x = 1;
        }
        return null;
    }

}
