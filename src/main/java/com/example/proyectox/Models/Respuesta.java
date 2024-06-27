package com.example.proyectox.Models;

public class Respuesta {
    private int id_respuesta;
    private String respuesta;
    private int efecto_respuesta;
    private int id_respuesta_pregunta;

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getEfecto_respuesta() {
        return efecto_respuesta;
    }

    public void setEfecto_respuesta(int efecto_respuesta) {
        this.efecto_respuesta = efecto_respuesta;
    }

    public int getId_respuesta_pregunta() {
        return id_respuesta_pregunta;
    }

    public void setId_respuesta_pregunta(int id_respuesta_pregunta) {
        this.id_respuesta_pregunta = id_respuesta_pregunta;
    }



    public Respuesta(int id_respuesta, String respuesta, int efecto_respuesta, int id_respuesta_pregunta) {
        this.id_respuesta = id_respuesta;
        this.respuesta = respuesta;
        this.efecto_respuesta = efecto_respuesta;
        this.id_respuesta_pregunta = id_respuesta_pregunta;
    }

    public Respuesta() {
    }
}
