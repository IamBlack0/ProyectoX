package com.example.proyectox.Models;

public class Ranking {
    private int id_ranking;
    private int puntaje_ranking;
    private String fecha_ranking;
    private int id_ranking_usuario;

    public Ranking() {
    }

    public Ranking(int id_ranking, int puntaje_ranking, String fecha_ranking, int id_ranking_usuario) {
        this.id_ranking = id_ranking;
        this.puntaje_ranking = puntaje_ranking;
        this.fecha_ranking = fecha_ranking;
        this.id_ranking_usuario = id_ranking_usuario;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public int getPuntaje_ranking() {
        return puntaje_ranking;
    }

    public void setPuntaje_ranking(int puntaje_ranking) {
        this.puntaje_ranking = puntaje_ranking;
    }

    public String getFecha_ranking() {
        return fecha_ranking;
    }

    public void setFecha_ranking(String fecha_ranking) {
        this.fecha_ranking = fecha_ranking;
    }

    public int getId_ranking_usuario() {
        return id_ranking_usuario;
    }

    public void setId_ranking_usuario(int id_ranking_usuario) {
        this.id_ranking_usuario = id_ranking_usuario;
    }
}
