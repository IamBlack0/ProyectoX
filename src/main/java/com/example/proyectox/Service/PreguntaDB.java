package com.example.proyectox.Service;

import com.example.proyectox.Models.Pregunta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class PreguntaDB {
    Connection conexion;

    public PreguntaDB(){
        conexion = new Conexion().abrirDB();
    }

    public List<Pregunta> ObtenerPreguntas(){
        try {
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM preguntas";

            List<Pregunta> preguntas = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Pregunta pregunta = new Pregunta(
                        result.getInt("id_pregunta"),
                        result.getString("pregunta"),
                        result.getInt("id_pregunta_historia")
                );

                preguntas.add(pregunta);
            }

            result.close();
            stmt.close();
            return preguntas;

        } catch (Exception e) {
            int x = 1;
        }
        return null;
    }

}
