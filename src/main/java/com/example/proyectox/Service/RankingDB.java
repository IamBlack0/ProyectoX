package com.example.proyectox.Service;

import com.example.proyectox.Models.Ranking;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class RankingDB {
    Connection conexion;

    public RankingDB(){
        conexion = new Conexion().abrirDB();
    }

    public List<Ranking> ObtenerRanking(){
        try {
            Statement stmt = conexion.createStatement();
            String query = "SELECT * FROM ranking";

            List<Ranking> rankings = new ArrayList<>();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                Ranking ranking = new Ranking(
                        result.getInt("id_ranking"),
                        result.getInt("puntaje_ranking"),
                        result.getString("fecha_ranking"),
                        result.getInt("id_ranking_usuario")
                );

                rankings.add(ranking);
            }

            result.close();
            stmt.close();
            return rankings;

        } catch (Exception e) {
            int x = 1;
        }
        return null;
    }

}
