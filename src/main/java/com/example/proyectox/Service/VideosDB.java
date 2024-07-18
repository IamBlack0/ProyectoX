package com.example.proyectox.Service;

import com.example.proyectox.Models.Videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideosDB {
    Connection conexion;

    public VideosDB() {
        conexion = new Conexion().abrirDB();
    }

    // VideosDB.java
    public List<Videos> obtenerVideosPorPersonaje(int idPersonaje, String plataforma) {
        try {
            String query = "SELECT * FROM videos WHERE id_personaje = ? AND plataforma_videos = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idPersonaje);
            stmt.setString(2, plataforma);

            List<Videos> videos = new ArrayList<>();
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Videos video = new Videos(
                        result.getInt("id_videos"),
                        result.getString("titulo_videos"),
                        result.getString("url_videos"),
                        result.getString("plataforma_videos"),
                        result.getInt("id_personaje")
                );

                videos.add(video);
            }

            result.close();
            stmt.close();
            return videos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
