package com.example.proyectox.Models;

public class Personaje {
    private int id_personaje;
    private String personaje;
    private int suministro_personaje;
    private int soldados_personaje;
    private String img_personaje;

    public Personaje() {
    }

    public Personaje(int id_personaje, String personaje, int suministro_personaje, int soldados_personaje, String img_personaje) {
        this.id_personaje = id_personaje;
        this.personaje = personaje;
        this.suministro_personaje = suministro_personaje;
        this.soldados_personaje = soldados_personaje;
        this.img_personaje = img_personaje;
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

    public int getSuministro_personaje() {
        return suministro_personaje;
    }

    public void setSuministro_personaje(int suministro_personaje) {
        this.suministro_personaje = suministro_personaje;
    }

    public int getSoldados_personaje() {
        return soldados_personaje;
    }

    public void setSoldados_personaje(int soldados_personaje) {
        this.soldados_personaje = soldados_personaje;
    }

    public String getImg_personaje() {
        return img_personaje;
    }

    public void setImg_personaje(String img_personaje) {
        this.img_personaje = img_personaje;
    }

}
