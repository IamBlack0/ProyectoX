package com.example.proyectox.Controllers;

import com.example.proyectox.Models.Pregunta;
import com.example.proyectox.Service.PreguntaDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Collections;

@RestController
public class PreguntaControllers {

    @GetMapping("/preguntas/all")
    public List<Pregunta> ObtenerTodosPregunta() {
        try {
            return new PreguntaDB().ObtenerPreguntas();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Retorna una lista vacía en caso de error
        }
    }
}
