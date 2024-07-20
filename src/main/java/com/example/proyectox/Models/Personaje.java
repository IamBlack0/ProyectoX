package com.example.proyectox.Models;

public class Personaje {
    private int id_personaje;
    private String personaje;
    private String img_personaje;
    private String lugar_personaje;
    private String fecha_personaje;
    private String mision_personaje;
    private String descripcion_personaje;
    private String audio_personaje; // Nuevo campo

    // Constructor actualizado
    public Personaje(int id_personaje, String personaje, String img_personaje, String lugar_personaje, String fecha_personaje, String mision_personaje, String descripcion_personaje, String audio_personaje) {
        this.id_personaje = id_personaje;
        this.personaje = personaje;
        this.img_personaje = img_personaje;
        this.lugar_personaje = lugar_personaje;
        this.fecha_personaje = fecha_personaje;
        this.mision_personaje = mision_personaje;
        this.descripcion_personaje = descripcion_personaje;
        this.audio_personaje = audio_personaje; // Inicializar el nuevo campo
    }

    public Personaje() {}

    // Getters y setters para el nuevo campo
    public String getAudio_personaje() {
        return audio_personaje;
    }

    public void setAudio_personaje(String audio_personaje) {
        this.audio_personaje = audio_personaje;
    }

    // Otros getters y setters...

    public String getDescripcion_personaje() {
        return descripcion_personaje;
    }

    public void setDescripcion_personaje(String descripcion_personaje) {
        this.descripcion_personaje = descripcion_personaje;
    }

    public String getMision_personaje() {
        return mision_personaje;
    }

    public void setMision_personaje(String mision_personaje) {
        this.mision_personaje = mision_personaje;
    }

    public String getLugar_personaje() {
        return lugar_personaje;
    }

    public void setLugar_personaje(String lugar_personaje) {
        this.lugar_personaje = lugar_personaje;
    }

    public String getFecha_personaje() {
        return fecha_personaje;
    }

    public void setFecha_personaje(String fecha_personaje) {
        this.fecha_personaje = fecha_personaje;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getImg_personaje() {
        return img_personaje;
    }

    public void setImg_personaje(String img_personaje) {
        this.img_personaje = img_personaje;
    }
}
