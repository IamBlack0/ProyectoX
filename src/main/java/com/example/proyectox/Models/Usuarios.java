package com.example.proyectox.Models;

public class Usuarios {
    private int id_usuario;
    private String nombre_usuario;
    private String correo_usuario;
    private String contra_usuario;
    private int rol_usuario;
    private String img_usuario; // Añadido

    // Getters y Setters

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getContra_usuario() {
        return contra_usuario;
    }

    public void setContra_usuario(String contra_usuario) {
        this.contra_usuario = contra_usuario;
    }

    public int getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(int rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public String getImg_usuario() {
        return img_usuario;
    }

    public void setImg_usuario(String img_usuario) {
        this.img_usuario = img_usuario;
    }
}
