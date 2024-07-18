package com.example.proyectox.Models;

public class Videos {
    private int id_videos;
    private String titulo_videos;
    private String url_videos;
    private String plataforma_videos;
    private int id_personaje;

    public Videos(int id_videos, String titulo_videos, String url_videos, String plataforma_videos, int id_personaje) {
        this.id_videos = id_videos;
        this.titulo_videos = titulo_videos;
        this.url_videos = url_videos;
        this.plataforma_videos = plataforma_videos;
        this.id_personaje = id_personaje;
    }

    public Videos() {
    }

    // Getters y Setters
    public int getId_videos() {
        return id_videos;
    }

    public void setId_videos(int id_videos) {
        this.id_videos = id_videos;
    }

    public String getTitulo_videos() {
        return titulo_videos;
    }

    public void setTitulo_videos(String titulo_videos) {
        this.titulo_videos = titulo_videos;
    }

    public String getUrl_videos() {
        return url_videos;
    }

    public void setUrl_videos(String url_videos) {
        this.url_videos = url_videos;
    }

    public String getPlataforma_videos() {
        return plataforma_videos;
    }

    public void setPlataforma_videos(String plataforma_videos) {
        this.plataforma_videos = plataforma_videos;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }
}
