package com.example.proyectox.Controllers;// VideoControllers.java

import com.example.proyectox.Models.Videos;
import com.example.proyectox.Service.VideosDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideosControllers {

    // VideosControllers.java
    @GetMapping("/personajes/{idPersonaje}/videos/{plataforma}")
    public List<Videos> obtenerVideosPorPersonaje(@PathVariable int idPersonaje, @PathVariable String plataforma) {
        return new VideosDB().obtenerVideosPorPersonaje(idPersonaje, plataforma);
    }

}
