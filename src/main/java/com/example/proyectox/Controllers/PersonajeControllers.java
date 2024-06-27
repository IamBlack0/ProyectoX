package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Personaje;
import com.example.proyectox.Service.PersonajeDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeControllers {
    @GetMapping("/personajes/all")
    public List<Personaje> ObtenerTodoPersonaje(){
        return new PersonajeDB().ObtenerPersonajes();
    }
}