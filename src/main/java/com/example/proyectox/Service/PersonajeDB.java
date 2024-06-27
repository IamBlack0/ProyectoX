package com.example.proyectox.Service;

import com.example.proyectox.Models.Personaje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class PersonajeDB {
    Connection conexion;

    public PersonajeDB(){
        conexion = new Conexion().abrirDB();
    }

    public List<Personaje> ObtenerPersonajes(){
        try {
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM personajes";

            List<Personaje> personajes = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Personaje personaje = new Personaje(
                        result.getInt("id_personaje"),
                        result.getString("personaje"),
                        result.getInt("suministro_personaje"),
                        result.getInt("soldados_personaje"),
                        result.getString("img_personaje")
                );

                personajes.add(personaje);
            }
            result.close();
            stmt.close();
            return personajes;

        } catch (Exception e) {
            int x = 1;
        }
        return null;
    }

}