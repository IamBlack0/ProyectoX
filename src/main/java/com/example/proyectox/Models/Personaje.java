package com.example.proyectox.Models;

public class Personaje {
    private int id_personaje;
    private String personaje;
    private String img_personaje;
    private String lugar_personaje;
    private String fecha_personaje;
    private String mision_personaje;
    private String descripcion_personaje;



    public Personaje(int id_personaje, String personaje, String img_personaje, String lugar_personaje, String fecha_personaje, String mision_personaje, String descripcion_personaje) {
        this.id_personaje = id_personaje;
        this.personaje = personaje;
        this.img_personaje = img_personaje;
        this.lugar_personaje = lugar_personaje;
        this.fecha_personaje = fecha_personaje;
        this.mision_personaje = mision_personaje;
        this.descripcion_personaje = descripcion_personaje; // Inicializar la nueva propiedad
    }

    public Personaje() {
    }

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