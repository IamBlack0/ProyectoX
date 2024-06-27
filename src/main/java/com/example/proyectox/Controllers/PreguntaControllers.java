package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Pregunta;
import com.example.proyectox.Service.PreguntaDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PreguntaControllers {
    @GetMapping("/preguntas/all")
    public List<Pregunta> ObtenerTodosPregunta(){
        return new PreguntaDB().ObtenerPreguntas();
    }
}
