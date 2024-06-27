package com.example.proyectox.Models;

public class Historia {
    private int id_historia;
    private String historia;
    private int id_historia_personaje;

    public Historia() {
    }

    public Historia(int id_historia, String historia, int id_historia_personaje) {
        this.id_historia = id_historia;
        this.historia = historia;
        this.id_historia_personaje = id_historia_personaje;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getId_historia_personaje() {
        return id_historia_personaje;
    }

    public void setId_historia_personaje(int id_historia_personaje) {
        this.id_historia_personaje = id_historia_personaje;
    }
}
