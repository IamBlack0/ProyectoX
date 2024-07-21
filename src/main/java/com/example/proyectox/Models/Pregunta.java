package com.example.proyectox.Models;

public class Pregunta {
    private int id_pregunta;
    private String pregunta;
    private String imagen_pregunta;
    private String audio_pregunta;
    private int id_personaje_pregunta;

    public Pregunta() {
    }

    public Pregunta(int id_pregunta, String pregunta, int id_personaje_pregunta, String imagen_pregunta, String audio_pregunta) {
        this.id_pregunta = id_pregunta;
        this.pregunta = pregunta;
        this.id_personaje_pregunta = id_personaje_pregunta;
        this.imagen_pregunta = imagen_pregunta;
        this.audio_pregunta = audio_pregunta;
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

    public String getImagen_pregunta() {
        return imagen_pregunta;
    }

    public void setImagen_pregunta(String imagen_pregunta) {
        this.imagen_pregunta = imagen_pregunta;
    }

    public String getAudio_pregunta() {
        return audio_pregunta;
    }

    public void setAudio_pregunta(String audio_pregunta) {
        this.audio_pregunta = audio_pregunta;
    }

    public int getId_personaje_pregunta() {
        return id_personaje_pregunta;
    }

    public void setId_personaje_pregunta(int id_personaje_pregunta) {
        this.id_personaje_pregunta = id_personaje_pregunta;
    }
}
