package com.example.proyectox.Service;

import com.example.proyectox.Models.Historia;
import com.example.proyectox.Models.Ranking;
import com.example.proyectox.Models.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class HistoriaDB {
    Connection conexion;

    public HistoriaDB(){
        conexion = new Conexion().abrirDB();
    }

    public List<Historia> ObtenerHistorias(){
        try {
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM historias";

            List<Historia> historias = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Historia historia = new Historia(
                        result.getInt("id_historia"),
                        result.getString("historia"),
                        result.getInt("id_historia_personaje")
                );

                historias.add(historia);
            }

            result.close();
            stmt.close();
            return historias;

        } catch (Exception e) {
            int x = 1;
        }
        return null;
    }

}
