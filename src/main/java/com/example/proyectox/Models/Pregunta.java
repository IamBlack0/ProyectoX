package com.example.proyectox.Models;

public class Pregunta {
    private int id_pregunta;
    private String pregunta;
    private int id_pregunta_historia;

    public Pregunta() {
    }

    public Pregunta(int id_pregunta, String pregunta, int id_pregunta_historia) {
        this.id_pregunta = id_pregunta;
        this.pregunta = pregunta;
        this.id_pregunta_historia = id_pregunta_historia;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getId_pregunta_historia() {
        return id_pregunta_historia;
    }

    public void setId_pregunta_historia(int id_pregunta_historia) {
        this.id_pregunta_historia = id_pregunta_historia;
    }
}
